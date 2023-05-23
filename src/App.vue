<template>
  <div id="app">
    <h1>Generador de Automóviles</h1>
    <div class="options">
      <label for="cantidad">Cantidad:</label>
      <input type="number" id="cantidad" v-model="cantidad" min="1" />
      <button @click="generarAutomoviles">Generar Automóviles</button>
    </div>
    <div class="filters">
      <input type="text" v-model="marcaFilter" placeholder="Filtrar por marca" />
      <input type="text" v-model="colorFilter" placeholder="Filtrar por color" />
      <button @click="filtrarAutomoviles">Aplicar Filtros</button>
    </div>
    <div class="automoviles">
      <div v-for="automovil in automoviles" :key="automovil.id" class="automovil-card">
        <h3>{{ automovil.marca }}</h3>
        <p>Año: {{ automovil.año }}</p>
        <p>Color: {{ automovil.color }}</p>
        <p>Precio: {{ automovil.precio }}</p>
        <button @click="verDetalles(automovil.id)">Ver Detalles</button>
      </div>
    </div>
    <div v-if="selectedAutomovil" class="detalles">
      <h2>Detalles del Automóvil</h2>
      <p>Marca: {{ selectedAutomovil.marca }}</p>
      <p>Año: {{ selectedAutomovil.año }}</p>
      <p>Color: {{ selectedAutomovil.color }}</p>
      <p>Precio: {{ selectedAutomovil.precio }}</p>
      <p>Tipo: {{ selectedAutomovil.tipo }}</p>
      <p>Motor: {{ selectedAutomovil.motor }}</p>
      <p>Cabinas: {{ selectedAutomovil.cabinas }}</p>
      <p>Sunroof: {{ selectedAutomovil.sunroof }}</p>
      <p>Popularidad: {{ selectedAutomovil.popularidad }}</p>
    </div>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      cantidad: 0,
      automoviles: [],
      marcaFilter: '',
      colorFilter: '',
      selectedAutomovil: null,
    };
  },
  methods: {
    generarAutomoviles() {
      axios
        .get(`/automoviles/${this.cantidad}`)
        .then(response => {
          this.automoviles = response.data;
        })
        .catch(error => {
          console.error(error);
        });
    },
    filtrarAutomoviles() {
      axios
        .get(`/automoviles?marca=${this.marcaFilter}&color=${this.colorFilter}`)
        .then(response => {
          this.automoviles = response.data;
        })
        .catch(error => {
          console.error(error);
        });
    },
    verDetalles(id) {
      axios
        .get(`/automoviles/${id}`)
        .then(response => {
          this.selectedAutomovil = response.data;
        })
        .catch(error => {
          console.error(error);
        });
    },
  },
};
</script>

<style>
#app {
  max-width: 800px;
  margin: 0 auto;
}

.options {
  margin-bottom: 20px;
}

.filters {
  margin-bottom: 20px;
}

.automovil-card {
  border: 1px solid #ccc;
  padding: 10px;
  margin-bottom: 10px;
}

.detalles {
  margin-top: 20px;
  border: 1px solid #ccc;
  padding: 10px;
}
</style>
