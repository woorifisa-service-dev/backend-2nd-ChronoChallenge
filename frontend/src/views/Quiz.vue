<template>
  <v-card class="mx-auto" width="80%" min-width="300">
    <v-card-text style="font-size: 20px">
      <span> 📝 2023-07-12</span>
      <span> 🪙 30 </span>
      <p class="question">다형성에 대해서 틀린 것은?</p>
    </v-card-text>
    <v-container fluid>
      <v-radio-group v-model="radios">
        <v-radio :value="item" v-for="item in 4" :key="item">
          <template v-slot:label>
            <div>
              Of course it's <strong class="text-success">Google</strong>
            </div>
          </template>
        </v-radio>
      </v-radio-group>
    </v-container>
    <v-card-actions style="display: flex; justify-content: end">
      <v-btn style="color: #fff; background-color: #2d4356"> 정답제출 </v-btn>
    </v-card-actions>
  </v-card>
</template>

<script setup>
import { ref } from "vue";

const radios = ref("");
</script>

<style scoped>
.question {
  font-size: 30px;
  font-weight: 600;
  padding: 20px 0;
}
</style>
