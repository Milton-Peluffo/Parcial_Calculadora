# RESPUESTAS DEL PARCIAL – Calidad de Software Avanzado

### EL SEGUNDO CONTRIBUIDOR QUE APARECE EN MI PROYECTO FUI YO MISMO TRABAJANDO DESDE OTRO DISPOSITIVO, YA QUE QUE NO ME ENCONTRABA EN CASA.

### DEMOSTRACION DE ERRORES DE LOS CI/CD


<img width="1901" height="352" alt="image" src="https://github.com/user-attachments/assets/342b4aea-3ddc-412c-adee-be1b105e6718" />
<img width="1887" height="694" alt="image" src="https://github.com/user-attachments/assets/4f367b8e-a325-4171-ba32-db802e5a0770" />

### DEMOSTRACION CI/CD SUPERADO
<img width="1889" height="622" alt="image" src="https://github.com/user-attachments/assets/d2e3e04f-20e9-4d80-9a19-686f64478f2a" />


## Parte 1 – Estrategia

### 1. Diferencia entre CI y CD
CI (Integración Continua) es el proceso donde cada vez que subo o actualizo algo en el repositorio, el proyecto se construye y se prueban las cosas automáticamente. Sirve para detectar errores rápido y evitar que el código se dañe sin que uno se dé cuenta.

CD (Esto significa: Entrega/Despliegue Continuo) va un paso más lejos. Además de construir y probar, también se encarga de preparar el software para entregarlo o incluso desplegarlo automáticamente. La idea es que el cambio llegue a producción de forma segura y sin tanto proceso manual.

### 2. Lenguaje, linter y herramienta de cobertura a usar, con justificación
Voy a usar Java, más que todo porque es un lenguaje estable, tengo práctica y además las herramientas del ecosistema facilitan bastante el pipeline.

El linter será Checkstyle, porque es el más común en Java, es fácil de integrar con Maven y noes tan complicado configurarlo. También ayuda a mantener el código ordenado y consistente.

Para la cobertura, usaré JaCoCo, que prácticamente es el estándar en proyectos Java con Maven. Funciona bien, genera reportes claros y no requiere configuraciones exageradas, además ya he trabajado con él.

### 3. Umbral mínimo de cobertura (80%)
Voy a usar un umbral del 80%. No es ni muy bajo ni exageradamente alto. Mantenerlo en 80% es razonable porque obliga a escribir pruebas suficientes sin volverlo una tortura, y además demuestra que el proyecto está relativamente bien cubierto.

<img width="569" height="39" alt="image" src="https://github.com/user-attachments/assets/253edefc-eef6-4738-a5d9-2511d4ebba03" />


## Parte 2 – Workflow CI/CD
El workflow se hará en un archivo llamado `ci-quality.yml` dentro de `.github/workflows/`.

Ahí se activará cuando haya un push o un pull_request.

El pipeline incluirá:
- Descargar el repositorio.
- Instalar dependencias.
- Pasar el linter (Checkstyle).
- Hacer el build con Maven.
- Ejecutar las pruebas unitarias.
- Obtener el reporte de cobertura con JaCoCo.
- Verificar que la cobertura cumpla el mínimo exigido.

### Informe de las pruebas unitarias con JaCoCo

<img width="1075" height="186" alt="image" src="https://github.com/user-attachments/assets/68089b3c-cb03-4b66-806a-624b35cd10ec" />


Si algún paso falla, el workflow debe detenerse inmediatamente.

## Parte 3 – Uso de nektos/act

Act es una herramienta que sirve para ejecutar los workflows de GitHub Actions directamente en el computador sin tener que subir cambios al repositorio. Es como simular GitHub Actions de manera local.

### ¿Qué hace?
Permite correr los pasos del workflow tal cual como GitHub lo haría, pero desde la máquina local. Eso ayuda a probar y corregir errores rápido sin esperar a que GitHub procese los workflows.

### Requisitos
Lo principal es tener Docker, porque act usa contenedores para ejecutar los jobs.

### Comando para ejecutar el workflow
```
act -j build
```
O simplemente:
```
act
```
## Parte 5 – IA y Ética

### Métodos para detectar código generado por IA
1. **Detección basada en patrones:**  
   Analiza si el estilo del código es demasiado uniforme o típico de ciertos modelos de IA.

2. **Comparación con modelos entrenados:**  
   Algunas herramientas comparan fragmentos del código con muestras generadas por IA.

### Por qué no se puede asegurar la autoría al 100%
Bueno, porque un humano puede modificar código generado por IA, y la IA puede imitar estilos humanos. No hay una forma infalible de identificar la autoría real.

### Políticas razonables sobre el uso de IA
- Permitir IA para explicaciones, pero no para generar código completo, siento que de esta manera se aprende mucho mejor.
- Aceptar su uso siempre que se declare cuándo se usó.
- Para complementar lo que dije primero, promover que la IA sea SOLO UN APOYO Y YA, no un reemplazo del aprendizaje, la mente está para usarse.
