## Parte 4 – Validación y logs

### Cómo identificar fallos en los logs

#### *Fallos del linter Checkstyle:*  
En Checkstyle muestra líneas del código que no cumplen reglas. Suelen verse así:

```
[ERROR] /src/main/java/org/miltonp/calculadora/Calculadora.java:15: 'if' child has incorrect indentation level 4, expected level should be 2. [Indentation]
[ERROR] /src/main/java/org/miltonp/calculadora/Main.java:10: Line is longer than 100 characters. [LineLength]
[ERROR] Failed during Checkstyle execution
[ERROR] Checkstyle violations detected. Aborting build.
```

Estos errores indican todo lo siguiente:
- El archivo donde ocurrió el problema.
- La línea exacta donde explotó.
- La regla de estilo que se incumplió.
- El build se detiene inmediatamente.

---

#### **Fallos en las pruebas JUnit:**  
Cuando un test falla, Maven lo muestra claramente así:

```
[INFO] Running org.miltonp.calculadora.CalculadoraTest
[ERROR] Tests run: 6, Failures: 1, Errors: 0, Skipped: 0
[ERROR] Failed tests:
[ERROR]   CalculadoraTest.testDividir:42 expected:<2.0> but was:<3.0>
[ERROR] 
[ERROR] Please refer to surefire-reports for individual test results.
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-surefire-plugin:3.1.2:test
```

Cómo identificarlo?:
- Esto muestra cuántas pruebas fallaron.
- Indica exactamente cuál test falló.
- Dice el valor esperado vs el recibido.

---

#### **Fallos de cobertura JaCoCo:**  
Cuando el total está por debajo del umbral (osea 80% en mi caso), aparece un log real similar a este:

```
[INFO] Analyzing coverage metrics...
[ERROR] Rule violated for bundle project: instructions covered ratio is 0.75, but expected minimum is 0.80
[ERROR] Failed to execute goal org.jacoco:jacoco-maven-plugin:0.8.10:check
```

Esto indica que:
- Cuál fue el porcentaje logrado.
- Cuál era el mínimo esperado.
- Que el build falló por cobertura insuficiente.

---

### Run fallido vs exitoso

#### **Run fallido**
Un run fallido se ve de esta forma:

```
[ERROR] BUILD FAILURE
[ERROR] Failed to execute goal ...
[ERROR] There are test failures.
[INFO] ------------------------------------------------------------------------
```

Características:
- El pipeline se detiene en la etapa donde ocurrió el error.
- Aparecen mensajes `[ERROR]`.
- GitHub Actions lo marca como **Failed**.

---

#### **Run exitoso**
y cuando un run es exitoso luce así:

```
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
```

Características:
- Todos los pasos se ejecutaron sin errores.
- No hay mensajes `[ERROR]`.
- GitHub Actions lo marca como **Success** con un color verde.