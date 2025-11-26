```mermaid
graph TD
  A[Client (Web / Mobile / CLI)] -->|HTTPS REST| B[Ingress / Load Balancer]
  B --> C[TaskHubAPI (Spring Boot)]

  subgraph App [TaskHubAPI - code (src/main/java)]
    C1[TaskHubApiApplication]
    C2[controller - TaskController]
    C3[service - TaskService]
    C4[repository - TaskRepository]
    C5[model - Entity/DTO]
    C6[config - SecurityConfig]
    C7[async - EventListeners]
  end

  C --> C1
  C1 --> C2
  C2 --> C3
  C3 --> C4

  C4 --> D[(MySQL Database)]
  C3 --> E[(Redis Cache)]
  C3 --> F[(Message Broker)]
  F --> G[Worker / Consumers]

  C --> H[Monitoring / Actuator / Logs]
```
