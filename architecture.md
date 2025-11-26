```mermaid
graph TD
  A[Client (Web / Mobile / CLI)] -->|HTTPS REST| B[Ingress / Load Balancer]
  B --> C[TaskHubAPI (Spring Boot)]
  subgraph App["TaskHubAPI - code (src/main/java)"]
    C1[com.example.TaskHubAPI.TaskHubApiApplication]:::core
    C2[controller.* (TaskController.java)]
    C3[service.* (TaskService, UserService)]
    C4[repository.* (TaskRepository)]
    C5[model.* (entities / dto)]
    C6[config.* (SecurityConfig, WebConfig)]
    C7[async.* (EventPublisher, Listeners)]
  end
  C --> C1
  C1 --> C2
  C2 --> C3
  C3 --> C4
  C4 --> D[(MySQL / RDBMS)]
  C3 --> E[(Redis Cache)]
  C3 --> F[(Message Broker - Rabbit/Kafka)]
  F --> G[Worker/Consumers]
  C --> H[Monitoring / Actuator / Logs]

  classDef core fill:#f9f,stroke:#333,stroke-width:1px;
