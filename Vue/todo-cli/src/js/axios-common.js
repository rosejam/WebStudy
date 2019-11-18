import axios from "axios";

export default axios.create({ //엑시오스 객체를 만들어서 export
    baseURL: "http://localhost:9090", //포트 번호
    headers: {
        "Content-type": "application/json", //데이터 타입
    }
});