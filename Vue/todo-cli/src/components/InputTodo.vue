<template>        
    <div>
        <button @click="go1">test1</button>
        <button @click="go2">test2</button>
        <input class="input" type="text" id="task" v-model.trim="todo" 
            placeholder="입력 후 엔터!" v-on:keyup.enter="addTodo"><!-- 엔터를 치거나 -->
        <span class="addbutton" v-on:click="addTodo">추 가</span>  <!-- 버튼처럼 보이는 span을 누르면 addTodo실행 -->
    </div>
</template>

<script>
export default {
    data: function(){
        return {
            todo:'' //template의 v-model에서 양방향으로 연결되어 있음
        }
    },
    methods:{
        go1(){ //store안의 action call
            this.$store.dispatch("test1", {num: 12345}); //"test1"은 action안의 메소드
        },
        go2(){
            this.$store.dispatch("test2");
        },
        addTodo(){ 
            //list-compo에게 사건 발생 알리고 데이터 전달
            //bus.$emit('add-todo', this.todo); //this.을 빼먹으면 안됨!! 이 객체의 data의 todo이므로!
            
            //input칸 비우기
            this.todo = '';
        }
    }
}
</script>

<style>
.input {
    border: none; width: 75%; height:35px; padding: 10px;
    float: left; font-size: 16px;
}
.addbutton {
    padding: 10px; width: 25%; height:35px; background: #d9d9d9; 
    color: #555; float: left; text-align: center;
    font-size: 13px; cursor: pointer; transition: 0.3s;
}
.addbutton:hover { background-color: #bbb; }
</style>