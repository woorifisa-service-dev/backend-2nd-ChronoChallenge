<template>
  <v-row justify="center">
    <v-dialog
      v-model="props.dialog"
      fullscreen
      :scrim="false"
      transition="dialog-bottom-transition"
    >
      <v-card>
        <v-toolbar dark color="#2D4356">
          <v-toolbar-items style="flex: 1; justify-content: end">
            <v-btn icon dark @click="props.setDialog" style="color: #fff">
              <v-icon>mdi-close</v-icon>
            </v-btn>
          </v-toolbar-items>
        </v-toolbar>

        <v-divider></v-divider>
        <form>
          <div v-for="(multiple, idx) in 4" :key="idx" class="answer-list">
            <input
              type="radio"
              :value="idx"
              name="multiple"
              :id="idx"
              :checked="idx + 1 == props.currentQuiz.answer ? true : false"
              disabled
            />
            <label :for="idx">{{
              props.currentQuiz[`multipleCandidate${idx + 1}`]
            }}</label>
          </div>
        </form>
        <v-divider></v-divider>
        <p class="answer">정답: {{ props.currentQuiz.answer }} 번</p>
      </v-card>
    </v-dialog>
  </v-row>
</template>

<script setup>
import { ref } from "vue";

const props = defineProps({
  dialog: Boolean,
  setDialog: Function,
  currentQuiz: Object,
});
</script>

<style scoped>
.quiz-title {
  color: #000;
  font-size: 20px;
  font-weight: bold;
}
.answer {
  padding: 20px 10px;
}
input:disabled {
  color: #000;
  border-color: darkblue;
}
form {
  padding: 0 10px;
}
.answer-list {
  display: flex;
  gap: 10px;
}
</style>
