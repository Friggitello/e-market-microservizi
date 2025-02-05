# E-commerce Microservices Project

Questo è un progetto a microservizi di e-commerce progettato con **Spring Boot** e **Docker Compose**.

## 🚀 Tecnologie Utilizzate

DA CAMBIARE
- **Spring Boot** - Framework principale per lo sviluppo dei microservizi
- **Docker Compose** - Per la gestione dei container
- **Spring Cloud** - Per il service discovery, load balancing e configurazione centralizzata
- **Spring Security** - Per l'autenticazione e l'autorizzazione
- **JWT (JSON Web Token)** - Per la gestione dei token di autenticazione
- **MySQL** - Database relazionale
- **Postman** - Per il testing delle API

## 📌 Struttura dei Microservizi

Il progetto è suddiviso nei seguenti microservizi:

DA CAMBIARE
- **Service Gateway** - API Gateway per la gestione delle richieste
- **User Service** - Gestione degli utenti e autenticazione
- **Product Service** - Gestione dei prodotti
- **Order Service** - Gestione degli ordini
- **Payment Service** - Gestione dei pagamenti
- **Notification Service** - Invio notifiche agli utenti

## 📦 Setup del Progetto

### Prerequisiti

Assicurati di avere installato:
- [Docker](https://www.docker.com/get-started)
- [Docker Compose](https://docs.docker.com/compose/install/)
- [JDK 23](https://jdk.java.net/23/)
- [Maven](https://maven.apache.org/)

### 🚀 Avvio del Progetto

1. Clona il repository:
   ```sh
   git clone https://github.com/Friggitello/e-market-microservizi.git
   cd e-market-microservizi
   ```
2. Avvia i servizi con Docker Compose:
   ```sh
   docker-compose up -d
   ```
3. Accedi all'API Gateway su:
   ```
   http://localhost:8080
   ```

## 🛠 Testing delle API

Puoi testare le API utilizzando **Postman** importando la collection presente nella cartella `postman/`.

## 📜 Licenza

Questo progetto è rilasciato sotto la licenza **MIT**.

---

🔧 *Sviluppato da Gabriel(https://github.com/Friggitello)*
