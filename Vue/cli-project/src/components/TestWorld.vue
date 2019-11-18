<template>
    <div>
        <button @click="go">test world</button>
    </div>
</template>

<script>
export default {
    name: "test",
    data: function (){ //component에 data넣을 때 꼭 리턴하도록 해줘야 한다!
        return {
            message: 'gogogo'
        }
    },
    methods: {
        go(){
            alert(this.message);
        }
    }
}
</script>

<style scoped>
button{
    background-color: aqua;
}
</style>