//export-import: javascript file의 module화와 관련된 기능
//module -> 재사용 가능한 단위. function, object, variable등이 포함될 수 있음

function hello(str){
    return "hello..." + str;
}
function hello2(str){
    return "hello2..." + str;
}

var student = {
    name: 'tommy kim',
    age: 25,
    address: 'seoul'
}; //json객체

const pi = 3.14;
var singer = 'Michael Jackson';

//export : 한 파일에서 작성된 함수나 데이터, 객체 등을 다른 스크립트 파일에서 사용 가능하도록 선언!

//named export : 이름이 있는 export
//  export되지 않은 hello2메소드 같은 대상들은 다른곳에서 사용 불가(자바의 private과 유사)
export {hello, student, pi};
export {singer};

//default export : 이름이 없는 export. 따라서 파일마다 1개만 사용가능
export default {
    num: 999,
    id: 'folly',
    pw: '56789'
} //여기서는 객체를 작성해서 넣었다.