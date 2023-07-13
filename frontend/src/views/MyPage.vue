<template>
  <section>
    <h2>
      박지윤 님 안녕하세요
    </h2>
    <ul class="info-list">
      <li>
        <h5>맞힌 퀴즈 개수</h5>
        <p>4</p>
      </li>
      <li>
        <h5>포인트</h5>
        <p>40</p>
      </li>
      <li>
        <h5>지각 면제권</h5>
        <p>4</p>
      </li>
    </ul>
  </section>

</template>

<script setup>
</script>

<style scoped>
section {
  padding: 20px;
}
.info-list {
  display: flex;
  width:100%;
  justify-content: space-between;
  margin: 20px 0;
}
li {
  list-style: none;
  text-align: center;
  width: calc(100%  / 3);
}
li + li {
  border-left: 1px solid #000;
}
li h5 {
  font-size: 20px;
}

</style>
