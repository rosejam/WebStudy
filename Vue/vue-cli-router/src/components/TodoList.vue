<template>
  <div>
    <ul>
      <li v-for="(todoItem) in todolist" v-bind:key="todoItem.id" class="shadow" 
      :class="{done: todoItem.done=='Y'}" @click.stop="getTodo(todoItem.id)">

        <i class="checkBtn fas fa-check"          
          v-show="todoItem.done =='N'" @click.stop="completeTodo(todoItem.id)"></i> <!-- 체크하는 아이콘 -->
        {{todoItem.todo}}:{{todoItem.endDate}} <!-- 꺼내서 이 두정보만 출력 -->
        <span
          class="removeBtn" type="button" @click.stop="removeTodo(todoItem.id)">
          <i class="far fa-trash-alt"></i>
        </span>
      </li>
    </ul>
  </div>
</template>

<script>
import Constant from '../Constant';

export default {
  computed: {
    //store안의 todolist check
    todolist() {
      return this.$store.state.todolist;
    }
  },
  created () {
    this.$store.dispatch(Constant.GET_TODOLIST); //action call
  },
  methods: {
    //getTodo, removeTodo, completeTodo
    getTodo(id){
      this.$router.push('/detail/' + id);//'/detail/:id'을 통해 TodoDetail.vue로 화면이 넘어가야 함
    },
    removeTodo(id){
      this.$store.dispatch(Constant.REMOVE_TODO, {id}); //data이름 없이 그냥 보냈는데 받는 쪽에서 payload로 받음
    },
    completeTodo(id){
      this.$store.dispatch(Constant.COMPLETE_TODO, {id});
    }
  },
};
</script>

<style scoped>
ul {
  list-style-type: none;
  padding-left: 0px;
  margin-top: 0;
  text-align: left;
}
li {
  display: flex;
  min-height: 50px;
  height: 50px;
  line-height: 50px;
  margin: 0.5rem 0;
  padding: 0 0.9rem;
  background: white;
  border-radius: 5px;
}
.checkBtn {
  line-height: 45px;
  color: #62acde;
  margin-right: 5px;
}
.removeBtn {
  margin-left: auto;
  color: #de4343;
}

.list-item {
  display: inline-block;
  margin-right: 10px;
}
.list-move {
  transition: transform 1s;
}
.list-enter-active,
.list-leave-active {
  transition: all 1s;
}
.list-enter,
.list-leave-to {
  opacity: 0;
  transform: translateY(30px);
}
.done{
  background-color: lightslategray;
}
</style>