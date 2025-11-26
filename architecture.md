```mermaid
graph TD
  Client[Client] -->|HTTP| App[TaskHubAPI (Single Spring Boot App)]

  App --> Entry[TaskHubApiApplication.java]
  App --> Config[application.properties]

  App --> DB[Database (Not included in ZIP)]
  App --> Cache[Cache (Not included)]
  App --> MQ[Message Broker (Not included)]
  App --> Monitoring[Monitoring/Actuator (Not configured)]
