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
        <v-form>
          <v-radio-group v-model="radios">
            <template v-slot:label>
              <div class="quiz-title">
                {{ props.currentQuiz }} 다형성에 대해 틀린 것을 고르시오
              </div>
            </template>
            <v-radio :value="item" v-for="item in 4" :key="item">
              <template v-slot:label>
                <div>{{ item }} 객체지향 어쩌고 저쩌고</div>
              </template>
            </v-radio>
          </v-radio-group>
        </v-form>
      </v-card>
    </v-dialog>
  </v-row>
</template>

<script setup>
import { ref } from "vue";

const props = defineProps({
  dialog: Boolean,
  setDialog: Function,
  currentQuiz: Number,
});
const radios = ref("");
</script>

<style scoped>
.quiz-title {
  color: #000;
  font-size: 20px;
  font-weight: bold;
}
</style>
