# The backend of the project, written in spring boot.

[Official Documentation link](https://bankingapi.netlify.app/)

## How to run it ?

### Prerequisite:

- Java 17: install it by running the following command on Debian `sudo apt install openjdk-17-jdk-headless`
- maven: install it by running the following command on Debian `sudo apt install maven`
- docker:
  - docker: follow this [guide](https://docs.docker.com/engine/install/) for installation
  - [optional] docker-compose: `sudo apt install docker-compose`

### Build and run the project

- Clone this repo : <br/>`git clone https://github.com/jotterkain/finance.git` <br/> or using github cli <br/> `gh repo clone jotterkain/finance`
- Move into the backend folder `cd finance/backend`
- Run `maven clean install`
- Create an `.env` file at the root of the backend directory with the following variables:
  ```
  POSTGRES_USER=your_db_username
  POSTGRES_PASSWORD=your_db_password
  ```
- run: `docker compose up` or `docker-compsoe up` if you have installed `docker-compose`.
- If no errors, the project is running and listening to `http://localhost:8080`. Try `http://localhost:8080/api/v1/customers`