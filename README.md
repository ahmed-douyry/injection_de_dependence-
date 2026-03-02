# Projet d'Injection de Dépendances avec Spring Framework

## 📋 Description du Projet

Ce projet est une démonstration pratique des concepts d'**Injection de Dépendances (DI)** et d'**Inversion de Contrôle (IoC)** en utilisant le framework **Spring**. Il illustre plusieurs approches pour configurer et injecter des dépendances dans une application Java.

## 🎯 Objectifs du Projet

- Comprendre les principes de l'injection de dépendances
- Démontrer différentes méthodes de configuration Spring :
  - Configuration XML (fichier `config.xml`)
  - Configuration par annotations (`@Component`, `@Autowired`)
  - Injection par constructeur et par setter
- Implémenter une architecture en couches (DAO, Métier, Présentation)

## 📁 Structure du Projet

```
injection_de_dependence-/
├── src/
│   └── main/
│       ├── java/
│       │   └── net/app/
│       │       ├── dao/                    # Couche d'accès aux données (version 1)
│       │       │   ├── IDao.java          # Interface DAO
│       │       │   └── DaoImpl.java        # Implémentation basée sur une base de données
│       │       ├── dao2/                   # Couche d'accès aux données (version 2)
│       │       │   └── IDaoImplv2.java    # Implémentation basée sur un capteur
│       │       ├── metier/                 # Couche métier (logique applicative)
│       │       │   ├── IMetier.java       # Interface de la couche métier
│       │       │   └── MetierImpl.java     # Implémentation de la logique métier
│       │       └── presentation/           # Couche présentation (points d'entrée)
│       │           ├── Pres1.java         # Approche manuelle (sans Spring)
│       │           ├── Pres2.java         # Approche avec Spring
│       │           ├── PresSpringXml.java # Configuration par XML
│       │           └── PresSpringAnnotation.java  # Configuration par annotations
│       └── resources/
│           └── config.xml                 # Configuration Spring en XML
├── pom.xml                                # Configuration Maven
├── config.txt                             # Fichier de configuration supplémentaire
└── README.md                              # Ce fichier

```

## 🔧 Technologies Utilisées

- **Langage** : Java 23
- **Framework** : Spring Framework 6.2.15
  - `spring-context` : Contexte Spring et gestion des beans
  - `spring-core` : Noyau de Spring
  - `spring-beans` : Gestion des beans Spring
- **Outil de build** : Apache Maven
- **Version Java** : 23

## 📦 Dépendances Maven

```xml
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-context</artifactId>
    <version>6.2.15</version>
</dependency>
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-core</artifactId>
    <version>6.2.15</version>
</dependency>
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-beans</artifactId>
    <version>6.2.15</version>
</dependency>
```

## 🏗️ Architecture du Projet

### Couche DAO (Data Access Object)

**Interfaces et Implémentations** :
- `IDao.java` : Interface définissant la méthode `getData()`
- `DaoImpl.java` : Implémentation basée sur une base de données (version 1)
- `IDaoImplv2.java` : Implémentation basée sur un capteur (version 2)

**Rôle** : Abstrait l'accès aux données et permet de changer facilement de source de données.

### Couche Métier (Business Logic)

**Interfaces et Implémentations** :
- `IMetier.java` : Interface définissant la méthode `calcul()`
- `MetierImpl.java` : Implémentation de la logique métier

**Rôle** : Contient la logique applicative. Elle reçoit une implémentation de `IDao` par injection de dépendances.

**Logique** : Calcule la surface d'une sphère selon la formule : `Surface = 2 * π * r²`

### Couche Présentation (Presentation Layer)

Quatre approches différentes d'instanciation et d'injection :

1. **Pres1.java** : Approche manuelle (sans Spring)
   - Crée manuellement les instances des objets
   - Injection manuelle par constructeur
   - Pas de gestion par Spring

2. **Pres2.java** : Point d'entrée supplémentaire

3. **PresSpringXml.java** : Configuration Spring par fichier XML
   - Charge le contexte Spring à partir de `config.xml`
   - Récupère le bean `metier` du conteneur Spring
   - Utilise `ClassPathXmlApplicationContext`

4. **PresSpringAnnotation.java** : Configuration Spring par annotations
   - Charge le contexte Spring avec annotations
   - Analyse automatiquement les classes annotées `@Component`
   - Utilise `AnnotationConfigApplicationContext`

## 🔌 Types d'Injection de Dépendances

### 1. Injection par Constructeur

```java
public MetierImpl(@Qualifier("d2") IDao dao) {
    this.dao = dao;
}
```

- La dépendance est passée lors de la création de l'objet
- Garantit que l'objet est initialisé correctement
- Permet l'utilisation de `@Qualifier` pour sélectionner une implémentation spécifique

### 2. Injection par Setter

```java
public void setDao(IDao dao) {
    this.dao = dao;
}
```

- Utilisée dans la configuration XML (`config.xml`)
- Permet une configuration optionnelle des dépendances
- Plus flexible mais moins sûre que l'injection par constructeur

## ⚙️ Configuration XML

Le fichier `src/main/resources/config.xml` définit les beans Spring :

```xml
<bean id="d" class="net.app.dao.DaoImpl"></bean>
<bean id="metier" class="net.app.metier.MetierImpl">
    <property name="dao" ref="d"></property>
</bean>
```

**Explications** :
- Le bean "d" est une instance de `DaoImpl`
- Le bean "metier" est une instance de `MetierImpl` avec injection de la dépendance "d" par setter

## 🏃 Comment Exécuter le Projet

### Compilation avec Maven

```bash
cd /home/douyry/Bureau/master\ sdia/system\ distribue/injection_de_dependence-
mvn clean compile
```

### Exécution des différentes approches

#### 1. Approche Manuelle (Pres1)
```bash
mvn exec:java -Dexec.mainClass="net.app.presentation.Pres1"
```

#### 2. Configuration XML (PresSpringXml)
```bash
mvn exec:java -Dexec.mainClass="net.app.presentation.PresSpringXml"
```

#### 3. Configuration par Annotations (PresSpringAnnotation)
```bash
mvn exec:java -Dexec.mainClass="net.app.presentation.PresSpringAnnotation"
```

### Packaging en JAR

```bash
mvn package
java -jar target/inversion_de_controle-1.0-SNAPSHOT.jar
```

## 📊 Flux d'Exécution

```
Couche Présentation (Pres1/PresSpringXml/PresSpringAnnotation)
    ↓
Couche Métier (MetierImpl)
    ↓
Couche DAO (DaoImpl ou IDaoImplv2)
    ↓
Retour du résultat (calculé : 2 * π * r²)
```

## 🎓 Concepts Clés Illustrés

1. **Inversion de Contrôle (IoC)** : Spring crée et gère les instances des objets
2. **Injection de Dépendances (DI)** : Les dépendances sont injectées plutôt que créées localement
3. **Polymorphisme** : Utilisation d'interfaces pour permettre différentes implémentations
4. **Annotations Spring** :
   - `@Component` : Marque une classe comme composant Spring
   - `@Autowired` : Injecte une dépendance automatiquement
   - `@Qualifier` : Sélectionne une implémentation spécifique quand plusieurs existent

5. **Découplage** : Les classes ne dépendent pas des implémentations concrètes, mais des interfaces

## 📝 Notes Importantes

- Le projet utilise **Java 23** et **Spring 6.2.15** (versions récentes)
- Les fichiers sont possédés par l'utilisateur `douyry` pour permettre la compilation
- Le projet suit une architecture en trois couches (DAO, Métier, Présentation)
- Plusieurs implémentations de `IDao` permettent de tester l'injection avec différentes sources


## 📚 Ressources Supplémentaires

- [Spring Documentation](https://spring.io/projects/spring-framework)
- [Dependency Injection Pattern](https://en.wikipedia.org/wiki/Dependency_injection)
- [Spring IoC Container](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans)

## 👨‍💼 Auteur

Projet créé dans le cadre du master SDIA - Systèmes Distribués

---

**Dernière mise à jour** : Mars 2026

