import Vue from 'vue';
import Vuex from 'vuex';
import Constant from './Constant';
import axios from './axios-common';

Vue.use(Vuex);

const store = new Vuex.Store({
    
    //state
    state: {
        todolist: [],
        todo: {},
        message: ''
    },

    actions: { // 외부와의 통신을 통해 데이터 처리 dispath에 의해 호출됨.
        [Constant.GET_TODOLIST]: store => {
            axios
            .get("/todolist/all")
            .then(response => {
                store.commit(Constant.GET_TODOLIST, {todolist: response.data});
            })
            .catch(exp => alert("getTodoList처리에 실패하였습니다. " + exp));
        },
        [Constant.GET_TODO]: (store, payload) => {
            axios
            .get("/todolist/todo/" + payload.id)
            .then(response => {
                store.commit(Constant.GET_TODO, {todo: response.data});
            })
            .catch(exp => alert("getTodo처리에 실패하였습니다. " + exp));
        },
        [Constant.ADD_TODO]: (store, payload) => {
            axios
            .post("/todolist/todo", payload.todo) //this.todo로 넣었던 todo객체
            .then(response => {
                store.commit(Constant.ADD_TODO, {message: response.data.message}); //db쪽 서버에서 response entity로 넣어 리턴한 메시지를 받아온다!
                store.dispatch(Constant.GET_TODOLIST); //위와 두줄 순서는 상관없는듯
                //console.log(response.data);
            })
            .catch(exp => alert("삽입 처리에 실패하였습니다. " + exp));
        },
        [Constant.REMOVE_TODO]: (store, payload) => {
            axios
            .delete("/todolist/todo/" + payload.id)
            .then(() => {
                store.dispatch(Constant.GET_TODOLIST);
            })
            .catch(exp => alert("삭제 처리에 실패하였습니다. " + exp));
        },
        [Constant.COMPLETE_TODO]: (store, payload) => {
            axios
            .put("/todolist/todo/done/" + payload.id)
            .then(() => {
                store.dispatch(Constant.GET_TODOLIST);
            })
            .catch(exp => alert("체크 처리에 실패하였습니다. " + exp));
        }
    },

    mutations: { // 저장소에 데이터 실제 반영(commit시 호출됨)
        [Constant.GET_TODOLIST]: (state, payload) => {
            state.todolist = payload.todolist;
        },
        [Constant.GET_TODO]: (state, payload) => {            
            state.todo = payload.todo;
            state.message = ''; //그냥 여기서 지워주었다
        },
        [Constant.ADD_TODO]: (state, payload) => {
            state.message = payload.message;
        }
    }
});


export default store;