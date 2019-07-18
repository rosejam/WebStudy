# -*- coding: utf-8 -*-
import re
import urllib.request
import matplotlib.pyplot as plt
import matplotlib
#import matplotlib.font_manager as fm
from slack.web.classes import extract_json
from slack.web.classes.blocks import *


from bs4 import BeautifulSoup

from flask import Flask
from slack import WebClient
from slackeventsapi import SlackEventAdapter

SLACK_TOKEN = 'xoxb-689227472356-683507776017-jhsrm8CrT6kp3bJlSBGToQJ5'
SLACK_SIGNING_SECRET = 'd4531fa95a896044b99101f83843931e'

app = Flask(__name__)
# /listening 으로 슬랙 이벤트를 받습니다.
slack_events_adaptor = SlackEventAdapter(SLACK_SIGNING_SECRET, "/listening", app)
slack_web_client = WebClient(token=SLACK_TOKEN)


# 크롤링 함수 구현하기
def _crawl_naver_keywords(text):
    # if not "coin" in text:
    #     return "`@<봇이름> coin` 과 같이 멘션해주세요."


    # 여기에 함수를 구현해봅시다.
    url = "https://www.binance.com/kr/markets"
    req = urllib.request.Request(url)
    source_code = urllib.request.urlopen(url).read()
    soup = BeautifulSoup(source_code, "html.parser")
    # if "목록" in text:
    #     return

    lists = []
    corpus = []
    for_graph = []
    for t in soup.find_all("div", class_="ReactVirtualized__Table__rowColumn"):
        lists.append(t.get_text())
    #        list=naver_text.get_text()
    for line in range(0, 153):
        blank = lists[(line * 9) + 0]
        a_btc = lists[(line * 9) + 1][:-6]
        coin_name = lists[(line * 9) + 2]
        last_trade = float(lists[(line * 9) + 3][:-1])
        yesterday = float(lists[(line * 9) + 4][:-1])
        top_price = float(lists[(line * 9) + 5])
        low_price = float(lists[(line * 9) + 6])
        blank_2 = lists[(line * 9) + 7]
        trade = float(lists[(line * 9) + 8].replace(',' , ''))
        new_tuple = (blank, a_btc, coin_name, last_trade, yesterday, top_price, low_price, blank_2, trade)
        corpus.append(new_tuple)
    ##corpus에 모든 정보 입력됨!!!
    #print(corpus)

    if "list" in text:
        for_list = []
        for num_l in range(0, 153):
            for_list.append(str(corpus[num_l][2])+ " ( " +str(corpus[num_l][1]) + " ) " + "    " )
        return "Binance에 상장된 총 153개의 암호화폐 목록이야!.. 자세한 정보를 알고 싶으면 멘션해줘..! \n\n" + ''.join(for_list)

    elif "high" in text :
        graph_count = int(text[17:])
        for_high = ["전일대비 많이 오른 순서대로 " + str(graph_count) + "개 암호화폐의 리스트야!..\n"]
        sorted_by_yesterday = sort_by_yesterday(corpus)
        for num_g in range(0, graph_count):
            for_high.append(str(num_g+1) +"위. " + str(sorted_by_yesterday[num_g][2]) + " ( " +str(sorted_by_yesterday[num_g][1])[:-6]+" ) " + " : " +  str(sorted_by_yesterday[num_g][4]) + "%\n")
        return ''.join(for_high)

    elif "low" in text :
        graph_count = int(text[16:])
        for_low = ["전일대비 많이 떨어진 순서대로 " + str(graph_count) + "개 암호화폐의 리스트야!..\n"]
        sorted_by_yesterday_low = sort_by_yesterday_low(corpus)
        for num_g in range(0, graph_count):
            for_low.append(str(num_g+1) +"위. " + str(sorted_by_yesterday_low[num_g][2]) + " ( " +str(sorted_by_yesterday_low[num_g][1])[:-6]+" ) " + " : " + str(sorted_by_yesterday_low[num_g][4]) + "%\n")
        return ''.join(for_low)

    elif "hgraph" in text:
        for_graph = []
        sorted_by_yesterday = sort_by_yesterday(corpus)
        graph_count = int(text[19:])
        for num_g in range(0, graph_count):
            graph_tuple = (sorted_by_yesterday[num_g][2], sorted_by_yesterday[num_g][4])
            for_graph.append(graph_tuple)
        draw_frequency_graph(for_graph)
        message = "전일대비 많이 오른 순서대로" + str(graph_count) + "개 암호화폐의 그래프를 보여줄게!.."
        return message

    elif "lgraph" in text:
        for_graph_low = []
        sorted_by_yesterday_low = sort_by_yesterday_low(corpus)
        graph_count = int(text[19:])
        for num_g in range(0, graph_count):
            graph_tuple = (sorted_by_yesterday_low[num_g][2], sorted_by_yesterday_low[num_g][4])
            for_graph_low.append(graph_tuple)
        draw_frequency_graph(for_graph_low)
        message = "전일대비 많이 떨어진 순서대로" + str(graph_count) + "개 암호화폐의 그래프를 보여줄게!.."
        return message


#####

    else:
        #text.replace(".", "") # 마침표가 들어간 입력도 비교하기 위해서!
        coin_ = text[13:]
        #print(coin_)
        for coin_row in corpus:
            #row_change=coin_row[2].replace(".", "")  # 마침표가 들어간 입력도 비교하기 위해서! ####왜 안됨
            #print(coin_row)
            if coin_ in coin_row[1]: #short name
                short_name_index = coin_row.index(coin_)
                price_index = short_name_index + 2
                long_name_index = short_name_index + 1
                price = coin_row[price_index]
                long_name = coin_row[long_name_index]
                short_name = coin_row[short_name_index]
                change_in_price_index = short_name_index + 3
                change_in_price = coin_row[change_in_price_index]
                exchange_amount_index= short_name_index + 7
                exchange_amount = coin_row[exchange_amount_index]
            elif coin_ in coin_row[2]: #long name
                long_name_index = coin_row.index(coin_)
                price_index = long_name_index + 1
                price = coin_row[price_index]
                short_name_index = long_name_index -1
                long_name = coin_row[long_name_index]
                short_name = coin_row[short_name_index]
                change_in_price_index = long_name_index + 2
                change_in_price = coin_row[change_in_price_index]
                exchange_amount_index = long_name_index + 6
                exchange_amount = coin_row[exchange_amount_index]
            else :
                pass
                #return "리스트에 있는 암호화폐 이름을 입력해줘."
        linked_coin_name = "<https://www.binance.com/kr/trade/" + str(short_name) + "_BTC" + "|" + str(long_name) + "(" + str(short_name) + ")>"
        if change_in_price <0:
            message = linked_coin_name + "의 가격은 지금 " + str(price) + " BTC야!.. \n전일 대비 " + str(abs(change_in_price)) + "% 내렸어..\n24시간동안 거래량은 " + str(exchange_amount) + " " + str(short_name) + "였어."
        else:
            message = linked_coin_name + "의 가격은 지금 " + str(price) + " BTC야!.. \n전일 대비 " + str(abs(change_in_price)) + "% 올랐어..\n24시간동안 거래량은 " + str(exchange_amount) + " " + str(short_name) + "였어."
        #     message = linked_coin_name + " 가격은 지금 " + str(price)[:-1] + " BTC야!..\n전일 대비 " + str(abs(change_in_price)) + "% 내렸어..\n24시간동안 거래량은 " + str(exchange_amount) + " " + uppername[:-6]+ "였어."
        # else :
        #     message = linked_coin_name + " 가격은 지금 " + str(price)[:-1] + " BTC야!..\n전일 대비 " + str(abs(change_in_price)) + "% 올랐어..\n24시간동안 거래량은 " + str(exchange_amount) + " " + uppername[:-6]+ "였어."


        # price_index = lists.index(corpus) + 1
        # price = lists[price_index]
        # #message = ''.join(price)
        # uppername_index = lists.index(coin_name) - 1
        # uppername = str(lists[uppername_index])     #ETH_BTC를 뜻함!!!!
        # uppername.replace('\xa0/\xa0','_')
        # linked_coin_name = "<https://www.binance.com/kr/trade/" + uppername[:-6] + "_BTC" + "|" + uppername[:-6] + ">"

        # change_in_price = lists[price_index+1][:-1]
        # change_in_price = float(change_in_price)
        # exchange_amount = lists[price_index+5]
        # if change_in_price <0:
        #     message = linked_coin_name + " 가격은 지금 " + str(price)[:-1] + " BTC야!..\n전일 대비 " + str(abs(change_in_price)) + "% 내렸어..\n24시간동안 거래량은 " + str(exchange_amount) + " " + uppername[:-6]+ "였어."
        # else :
        #     message = linked_coin_name + " 가격은 지금 " + str(price)[:-1] + " BTC야!..\n전일 대비 " + str(abs(change_in_price)) + "% 올랐어..\n24시간동안 거래량은 " + str(exchange_amount) + " " + uppername[:-6]+ "였어."
        return message



    #     # lists에는 작업물이 들어있다.
        # coin_name = text[13:]
        # price_index = lists.index(coin_name) + 2
        # price = lists[price_index]
        # message = ''.join(price)
        # #
        # return message
        # for i in range(0, 200):
        #     if i % 9 == 2:
        #         content.append(lists[i])
        # message = '\n'.join(content)
        # return message

        # elif ("전일" or "증감") in text:
        #     lists = []
        #     content = ["Binance 암호화폐 전일대비 증가량 순위"]
        #     for text in soup.find_all("div", class_="ReactVirtualized__Table__rowColumn"):
        #         lists.append(text.get_text())
        #     for i in range(0, 200):
        #         if i % 9 == 2:
        #             content.append(lists[i])
        #     message = '\n'.join(content)
        #     return message


    # lists = []
    # for_graph = []
    # #    content = ["Binance 비트코인 List"]
    #
    # for t in soup.find_all("div", class_="ReactVirtualized__Table__rowColumn"):
    #     lists.append(t.get_text())
    #     #그래핑과정
    # if "graph" in text:
    #     graph_count = int(text[18:])
    #
    #     for line in range(0,graph_count):
    #         word = lists[(line*9)+2]
    #         freq = lists[(line * 9) +4]
    #         freq = str(freq)[:-1]
    #         freq = float(freq)
    #         new_tuple = (word, freq)
    #         for_graph.append(new_tuple)
    #     message= "전일대비 많이 오른 순서대로 그래프를 보여줄게!.."
    #     sorted_for_graph = sort_by_updown(for_graph)
    #     draw_frequency_graph(sorted_for_graph)
    #     return message
    #     # lists에는 작업물이 들어있다.


#############


    # elif "이더리움" in text:
    #     lists = []
    #     dollar_lists = []
    #     for text in soup.find_all("div", class_="ReactVirtualized__Table__rowColumn"):
    #         lists.append(text.get_text())
    #     for text in soup.find_all("div", class_="sc-62mpio-0 ru9sa3-0 iesbJt"):
    #         dollar_lists.append(text.get_text())
    #
    #     coin_name = "ETC\xa0/\xa0BTC"     #텍스트를 통해 넣기
    #     price_index = int(lists.index(coin_name)) + 2
    #     dollar_index = int((price_index -3)/3)
    #     price = lists[price_index]
    #     dollar = dollar_lists[dollar_index]
    #     uppername_index = int(lists.index(coin_name))    #ETH_BTC를 뜻함!!!!
    #     uppername = lists[uppername_index]
    #     linked_coin_name = "<https://www.binance.com/kr/trade/" + str(uppername) + "|" + str(uppername)[:4] +">"
    #     message = linked_coin_name + "은 지금 " + str(price)[:-1] + " BTC 야!..\n" + "$" + str(dollar) + "이기도 해"
    #     return message






        # lists = []
        # tuples = []
        # content = ["Binance 비트코인 List"]
        # for text in soup.find_all("div", class_="ReactVirtualized__Table__rowColumn"):
        #     lists.append(text.get_text())
        # coin_name = 'Ethereum'
        # price_index = lists.index(coin_name) + 2
        # price = lists[price_index]
        # message = ''.join(price)
        #
        # return message


def draw_frequency_graph(for_graph):
    # 막대 그래프의 막대 위치를 결정하는 pos를 선언합니다.
    pos = range(len(for_graph))

    # 튜플의 리스트인 corpus를 단어의 리스트 words와 빈도의 리스트 freqs로 분리합니다.
    words = [tup[0] for tup in for_graph]
    freqs = [tup[1] for tup in for_graph]

    # 한국어를 보기 좋게 표시할 수 있도록 폰트를 설정합니다.
    #font = fm.FontProperties(fname='./NanumBarunGothic.ttf')
    ##matplotlib.rcParams.update({'font.size': 10})
    # 막대의 높이가 빈도의 값이 되도록 설정합니다.
    plt.bar(pos, freqs, align='center')

    # 각 막대에 해당되는 단어를 입력합니다.
    plt.xticks(pos, words, rotation='vertical')#, fontproperties=font)  # 글씨를 세로로 작성

    # 그래프의 제목을 설정합니다.
    plt.title('Ups&Downs')#, fontproperties=font)

    # Y축에 설명을 추가합니다.
    plt.ylabel('%')#, fontproperties=font)

    # 단어가 잘리지 않도록 여백을 조정합니다.
    plt.tight_layout()


    # 그래프를 표시합니다.
    plt.savefig('graph.png')
    file_name ='graph.png'
    slack_web_client.files_upload(channels = "#7조", file =file_name)
    #elice_utils.send_image('graph.png')

def sort_by_updown(corpus):
    return sorted(corpus, key=get_freq1, reverse=True)
def sort_by_yesterday(corpus):
    return sorted(corpus, key=get_freq4,  reverse=True)
def sort_by_yesterday_low(corpus):
    return sorted(corpus, key=get_freq4,  reverse=False)
def sort_by_trade(corpus):
    return sorted(corpus, key=get_freq8, reverse=True)

def get_freq1(pair):
    return pair[1]
def get_freq4(pair):
    return pair[4]
def get_freq8(pair):
    return pair[8]



# 챗봇이 멘션을 받았을 경우
@slack_events_adaptor.on("app_mention")
def app_mentioned(event_data):
    channel = event_data["event"]["channel"]
    text = event_data["event"]["text"]
    keywords = _crawl_naver_keywords(text)
    #my_blocks = [block1, block2, block3]
    slack_web_client.chat_postMessage(
        channel=channel,
        text=keywords,
    )


# / 로 접속하면 서버가 준비되었다고 알려줍니다.
@app.route("/", methods=["GET"])
def index():
    return "<h1>Server is ready.</h1>"


if __name__ == '__main__':
    app.run('127.0.0.1', port=5000)   #로컬주소 입력, 포트포워딩은 5000으로 해놓기 (ngrok)
