<template>
    <div>
        <ul id="todolist">
            <!-- computed todolist를 한번 호출하고 그 리턴값으로 뿌린다. 값이 바뀔 때마다 반복한다. -->
            <!-- :key="one.id"를 넣어야 에러가 없어짐 -->
            <li v-for="one in todolist" :key="one.id" :class="checked(one.done)" @click.stop="getTodo(one.id)"><!-- getTodo는 상세정보 -->
                <span class="check" @click.stop="completeTodo(one.id)">v</span>
                <span>{{one.todo}}</span>
                <span v-if="one.done==='Y'">(완료)</span>
                <span class="close" @click.stop="deleteTodo(one.id)">&#x00D7;</span>
            </li>
        </ul>
    </div>
</template>

<script>
import Constant from '../js/Constant'
export default {
    name: 'ListTodo',
    created: function(){ //mounted도 가능!!(조금 더 나중 데이터를 가져오기)
        this.$store.dispatch(Constant.ALL_TODO); //화면 로딩 할 때 data get하는 action call
            //state에 todolist받아옴
    },
    computed: { //getter
        todolist(){
            return this.$store.state.todolist; //todolist가 바뀔 때 마다 데이터를 화면으로 넘겨줌
        }
    },
    methods: {
        checked : function(done) {
            if(done==='Y') return { checked:true };
            else return { checked:false };
        },
        // addTodo : function(todo) { //()에 아까 보냈던 todo를 받아옴
        //     if(todo != ''){
        //         this.todolist.push({ id: this.todolist[this.todolist.length-1].id + 1, todo: todo, done:false});
        //     }
        // },
        getTodo: function(payload){
            this.$store.dispatch(Constant.GET_TODO, payload)
        },
        completeTodo : function(payload) {
            this.$store.dispatch(Constant.COMPLETE_TODO, payload)
        },
        deleteTodo : function(payload) {
            this.$store.dispatch(Constant.DELETE_TODO, payload);
        }
    }
}
</script>

<style scoped>
    ul {  margin: 0; padding: 0; }
    ul li { 
        cursor: pointer; position: relative; padding: 8px 8px 8px 40px;
        background: #eee; font-size: 14px;  transition: 0.2s;
        -webkit-user-select: none; -moz-user-select: none;
        -ms-user-select: none; user-select: none;  
    }
    ul li:hover {  background: #ddd;  }
    ul li.checked {
        background: #BBB;  color: #fff; text-decoration: line-through;
    }
    ul li.checked::before {
        content: ''; position: absolute; border-color: #fff;
        border-style: solid; border-width: 0px 1px 1px 0px; 
        top: 10px; left: 16px;  transform: rotate(45deg);
        height: 8px; width: 8px;
    }
    .close {
        position: absolute; right: 0; top: 0;
        padding: 12px 16px 12px 16px
    }
    .close:hover {
        background-color: #f44336;  color: white;
    }
    .check {
        position: absolute; left: 0; top: 0;
        padding: 12px 16px 12px 16px
    }
    .check:hover {
        background-color: blueviolet;  color: white;
    }
</style>