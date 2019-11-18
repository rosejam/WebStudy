<template>
    <div>
        <h1>SayWorld Vue</h1>
    </div>  
</template>

<script> 
export default { //이 파일을 App.vue에서 가져다 쓸 수 있게 export default안에서 작성한다.
    name: 'SayWorld', //이 컴포넌트 이름으로 위 template에서 태그 사용!!
    props: {
        code: String
    }
}
</script>

<style scoped>
h1{
    color: red;
}
</style>