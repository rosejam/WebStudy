//node_modules내부의 라이브러리에서 import
import Vue from 'vue'
import Vuex from 'vuex'
import axios from '../js/axios-common'
import Constant from '../js/Constant'

Vue.use(Vuex); //js파일 밖에서도 store를 사용할 수 있도록  global functionality 선언

const store = new Vuex.Store({

    //data: 여러 뷰 컴포넌트에서 공유하는 데이터
    state:{
        name: 'tommy jones',
        todolist: [] //server에서 온 데이터
    },

    //화면 구성요소에 의해 호출되는 메소드들.
    //"비동기 호출"을 수행. 작업이 끝나면 mutations를 호출함
    actions:{
        test1: (store, payload) => {
            console.log('actions called');
            store.commit('test1', payload); //mutation call
        },
        test2: (store) => {
            console.log('actions called');
            store.commit('test2'); //mutation call
        },
        [Constant.ALL_TODO]: store => { //메소드 이름을 constant를 활용해서 표현. key인데 마침표가 포함되므로 []로 감싼다
            //all***axios 요청 후 결과가 오면 mutation(store.commit)에 지시해서 state 변경 요청
            axios
            .get("/todolist/all")
            .then(response => {
                store.commit(Constant.ALL_TODO, { todolist: response.data });
                console.log(response.data); }) //서버에서 받은 데이터로 todolist 세팅해줌
            .catch(exp => alert("getTodoList처리에 실패하였습니다. " + exp));
        }
    },
    
    //actions에 의해 호출되는 메소드. state에 직접 접근해 데이터 변경 작업 수행
    //"동기 호출"을 수행. 작업이 끝나면 화면 구성요소가 바뀜
    mutations:{
        test1: (state, payload) => {
            console.log('mutations called');
            state.name = payload.num;
        },
        test2: (state) => {
            console.log('mutations called');
            state.name = 'billy kim';
        },
        [Constant.ALL_TODO]: (state, payload) => {
            state.todolist = payload.todolist;
        }
    }

});

export default store;