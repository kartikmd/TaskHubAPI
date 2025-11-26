```mermaid
graph TD

  %% Entry
  subgraph Entry
    Dev[Client / Developer]
    App[Spring Boot App\nTaskHubApiApplication]
  end

  %% Ingestion (HTTP)
  subgraph Ingestion
    TaskAPI[TaskController (REST)\nPOST /api/tasks]
    FileAPI[FileUploadController\nPOST /api/files]
  end

  %% Processing / Business Logic
  subgraph Processing
    Validator[InputValidator]
    TaskSvc[TaskService\n(business rules)]
    Mapper[DtoMapper / Model]
    Repo[TaskRepository\n(JPA)]
  end

  %% Async & Workers
  subgraph Async
    Broker[Message Broker\n(Rabbit/Kafka) - optional]
    Worker[Worker / Consumer\n(Notifications, Jobs)]
  end

  %% Persistence & Storage
  subgraph Persistence
    DB[(MySQL / RDBMS)]
    Cache[(Redis) - optional]
    FileStore[(uploads/  output/)]
  end

  %% Observability & Ops
  subgraph Observability
    Logs[SLF4J + Logback]
    Metrics[Actuator / Prometheus]
    Tracing[Tracing / APM (optional)]
  end

  %% Outputs
  subgraph Outputs
    APIResp[JSON Responses]
    Notifs[Email / Push Notifications]
    Reports[Reports / Export files]
  end

  %% Flow Connections
  Dev --> App
  App --> TaskAPI
  App --> FileAPI

  TaskAPI --> Validator
  Validator --> TaskSvc
  TaskSvc --> Mapper
  Mapper --> Repo
  Repo --> DB

  FileAPI --> FileStore
  TaskSvc --> FileStore

  TaskSvc --> Broker
  Broker --> Worker
  Worker --> Notifs
  Worker --> Reports
  TaskSvc --> Cache
  TaskAPI --> APIResp

  TaskAPI --> Logs
  TaskSvc --> Logs
  Repo --> Logs
  Worker --> Logs

  Logs --> Metrics
  Metrics --> Tracing
