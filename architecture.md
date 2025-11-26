```mermaid
graph TD
  Client --> LB
  LB --> Instance1
  LB --> Instance2
  Instance1 --> Controllers1
  Instance1 --> Services1
  Instance1 --> Repositories1
  Instance2 --> Controllers2
  Instance2 --> Services2
  Instance2 --> Repositories2
  Repositories1 --> DB
  Repositories2 --> DB
  Services1 --> Cache
  Services2 --> Cache
  Services1 --> MQ
  Workers --> MQ
  InstancesMonitoring[Monitoring / Logs] --> Instance1
  InstancesMonitoring --> Instance2
