# SmartLogi — Smart Delivery Management System

## 📋 Contexte

SmartLogi souhaite moderniser la gestion de ses livraisons pour remplacer le suivi manuel (Excel/papier) et résoudre les problèmes suivants :
- Erreurs de saisie et doublons
- Retards dans les livraisons
- Faible visibilité sur les opérations

## 🎯 Fonctionnalités

### Gestion des livreurs (CRUD)
- Créer, modifier, supprimer un livreur
- Consulter la liste des livreurs
- Chaque livreur : nom, prénom, véhicule, téléphone unique

### Gestion des colis (CRUD)
- Enregistrer un colis et l'assigner à un livreur
- Modifier les informations d'un colis
- Mettre à jour le statut : PREPARATION, EN_TRANSIT, LIVRE
- Lister tous les colis
- Lister les colis par livreur
- Supprimer un colis

## 🏗️ Architecture

```
SmartLogi/
├── src/main/java/com/exemple/smartLogi/
│   ├── model/
│   │   ├── Colis.java (entité JPA)
│   │   ├── Livreur.java (entité JPA)
│   │   └── enums/ColisStatut.java
│   ├── repository/
│   │   ├── ColiRepository.java (Spring Data JPA)
│   │   └── LivreurRepository.java
│   ├── service/
│   │   ├── coli/ColisService.java + ColisServiceImpl.java
│   │   └── livreur/LivreurService.java + LivreurServiceImpl.java
│   ├── controller/
│   │   ├── ColisController.java
│   │   └── LivreurController.java
│   └── mainApp.java
├── src/main/resources/
│   └── application.properties (config DB)
├── src/main/webapp/WEB-INF/
│   ├── web.xml (configuration servlet)
│   ├── applicationContext.xml (beans Spring, datasource, JPA)
│   └── spring-servlet.xml (configuration MVC)
└── pom.xml
```

## 💻 Technologies

- **Java** (version compatible Jakarta EE)
- **Spring Framework 7.0.0-RC1** : Core, Context, ORM, Web MVC
- **Spring Data JPA 4.0.0-RC1**
- **Hibernate 7.1.4.Final** (ORM)
- **PostgreSQL 42.7.8** (base de données)
- **Apache Commons DBCP2** (connection pooling)
- **Jackson** (sérialisation JSON)
- **Maven** (gestion de projet)
- **Apache Tomcat** (serveur d'application)

## ⚙️ Configuration

### Base de données PostgreSQL

Créer la base de données :
```sql
CREATE DATABASE smartlogi_db;
```

Configuration dans `src/main/resources/application.properties` :
```properties
db.driver=org.postgresql.Driver
db.url=jdbc:postgresql://localhost:5432/smartlogi_db
db.username=postgres
db.password=votre_mot_de_passe
```

### Configuration Spring

**Mode XML pur** (sans annotations) :
- `applicationContext.xml` : datasource, entityManagerFactory, transactionManager, repositories
- `spring-servlet.xml` : controllers, URL mappings
- Injection de dépendances configurée en XML

## 🚀 Installation et déploiement

### 1. Prérequis
- JDK 17+
- Maven 3.6+
- PostgreSQL 12+
- Apache Tomcat 10+

### 2. Build du projet
```bash
mvn clean package
```

Le fichier WAR sera généré dans `target/SmartLogi.war`

### 3. Déploiement sur Tomcat
```bash
# Copier le WAR dans Tomcat
copy target\SmartLogi.war %TOMCAT_HOME%\webapps\

# Démarrer Tomcat
%TOMCAT_HOME%\bin\startup.bat
```

### 4. Accès à l'application
```
http://localhost:8080/SmartLogi/
```

## 📡 API Endpoints

### Colis

**GET /colis** - Lister tous les colis
```
GET http://localhost:8080/SmartLogi/colis
Accept: application/json
```

**POST /colis** - Créer un colis
```
POST http://localhost:8080/SmartLogi/colis
Content-Type: application/x-www-form-urlencoded

Paramètres :
- idLivreur : UUID du livreur
- poids : nombre (ex: 2.5)
- destinataire : string
- adresse : string
- statut : PREPARATION | EN_TRANSIT | LIVRE
```

### Livreurs

**GET /livreur** - Lister tous les livreurs
```
GET http://localhost:8080/SmartLogi/livreur
Accept: application/json
```

**POST /livreur** - Créer un livreur
```
POST http://localhost:8080/SmartLogi/livreur
Content-Type: application/x-www-form-urlencoded

Paramètres :
- nom : string
- prenom : string
- vehicule : string
- telephone : string (unique)
```

## 🧪 Tests avec Postman

### Exemple 1 : Créer un livreur
```
POST http://localhost:8080/SmartLogi/livreur
Body (form-data):
  nom = Dupont
  prenom = Jean
  vehicule = Camionnette
  telephone = 0601020304
```

### Exemple 2 : Créer un colis
```
POST http://localhost:8080/SmartLogi/colis
Body (form-data):
  idLivreur = [UUID du livreur créé]
  poids = 5.2
  destinataire = Marie Martin
  adresse = 15 rue de Paris, 75001 Paris
  statut = PREPARATION
```

### Exemple 3 : Lister les colis
```
GET http://localhost:8080/SmartLogi/colis
Headers:
  Accept: application/json
```

## 📊 Modèle de données

### Entité Livreur
- `id` : String (UUID)
- `nom` : String
- `prenom` : String
- `vehicule` : String
- `telephone` : String (unique)
- `colisList` : List<Colis> (relation OneToMany)

### Entité Colis
- `id` : String (UUID)
- `destinataire` : String
- `adresse` : String
- `poids` : double
- `statut` : ColisStatut (enum)
- `livreur` : Livreur (relation ManyToOne, lazy)

### Enum ColisStatut
- `PREPARATION`
- `EN_TRANSIT`
- `LIVRE`


## 📝 Licence

Projet éducatif - SmartLogi
