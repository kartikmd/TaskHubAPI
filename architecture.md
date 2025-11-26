```mermaid
graph TD
  Client[Client (Web / Mobile / CLI)] -->|HTTP/HTTPS| App[TaskHubAPI (Single Spring Boot)]
  App --> Entry[TaskHubApiApplication.java]
  App --> Config[application.properties]
  App --> Controller[Controllers (add controllers here)]
  App --> Service[Service Layer (add services here)]
  App --> Repository[Repositories (add JPA repos here)]
  App --> DB[(Database) - not included in ZIP]
  App --> Cache[(Redis) - optional]
  App --> MQ[(Message Broker) - optional]
  App --> Monitoring[(Actuator / Metrics) - not configured]

