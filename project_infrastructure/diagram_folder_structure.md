# Folder structure

## Tree View

```
src/
├── main/
│   ├── java/
│   │   ├── com/
│   │   │   └── example/
│   │   │       └── appname/
│   │   │           ├── domain/             # Domain Layer: Business Logic Core
│   │   │           │   ├── model/               # Domain Models (Aggregates, Entities, Value Objects)
│   │   │           │   │   ├── aggregate/           # Aggregates: Root entities managing groups of entities
│   │   │           │   │   ├── entity/              # Entities: Non-root Entities (Shared or Included in Aggregates) / Domain objects with unique identity
│   │   │           │   │   └── valueobject/         # Value Objects: Immutable domain objects (no identity)
│   │   │           │   ├── factory/             # Factories: Centralized creation logic for domain objects (Instantiate Aggregates / Entities)
│   │   │           │   ├── service/             # Domain Services: Express core business logic (Business Logic Across Aggregates / Entities)
│   │   │           │   ├── event/               # Domain Events: Track State Changes or occurrences in the domain
│   │   │           │   ├── specification/       # Specifications: Domain validations rules
│   │   │           │   └── exception/           # Exceptions: Domain-specific errors or rule violations
│   │   │           ├── application/        # Application Layer: Orchestrates use cases and workflows (application Logic, Core Use Cases)
│   │   │           │   ├── port/                # Ports: Define boundaries for use cases
│   │   │           │   │   ├── in/                  # Input Ports: Interfaces for incoming requests (Use Cases)
│   │   │           │   │   └── out/                 # Output Ports: Interfaces for external resources/services (repositories, API gateways)
│   │   │           │   │       └── repositories/        # Repositories interfaces: db interfaces
│   │   │           │   ├── use_case/             # Use Case Implementations: Application logic for workflow
│   │   │           │   │   ├── command/             # Command Handlers: Handle state-changing (write logic) operations (can be a handler folder in case commands themselves are different from requestDTOs)
│   │   │           │   │   └── query/               # Query Handlers: Handle read-only operations
│   │   │           │   ├── dto/                 # DTOs: Data Transfer Objects for communication
│   │   │           │   │   ├── request/             # Request DTOs: Represent incoming user input
│   │   │           │   │   └── response/            # Response DTOs: Represent outgoing data
│   │   │           │   └── mapper/              # Mappers: Translate between domain and DTO objects
│   │   │           ├── adapter/            # Adapter Layer: Interfaces with external systems (Controllers, API Clients, DBs, Storage, Brokers, etc.)
│   │   │           │   ├── in/                  # Input Adapters: Accept data into the application
│   │   │           │   │   ├── rest/                # REST Controllers: Handle HTTP requests
│   │   │           │   │   └── messaging/           # Messaging Brokers listeners: Kafka, RabbitMQ, etc.
│   │   │           │   ├── out/                 # Output Adapters: Implement external integrations
│   │   │           │   │   ├── database/            # Implementation for database repositories
│   │   │           │   │   ├── messaging/           # Messaging Brokers producers: Kafka, RabbitMQ, etc.
│   │   │           │   │   ├── api/                 # External APIs: API clients to other systems
│   │   │           ├── infrastructure/     # Infrastructure Layer: Framework and driver concerns
│   │   │           │   ├── config/                  # Configurations: Frameworks and system setup ()
│   │   │           │   └── util/                    # Utilities: Shared infrastructure-specific helpers (logging, security, jwt, datetime, etc)
│   │   │           └── shared/                  # Shared Layer: Cross-cutting reusable components
│   │   │               ├── event/                   # Shared Event System: Publish/Subscribe events
│   │   │               ├── error/                   # Error Handling: Global and reusable exceptions
│   │   │               ├── constants/               # Shared Constants: Application-wide static values
│   │   │               └── utils/                   # Common Utilities: Helper classes and shared logic
│
└── README.md                               # Main ReadMe describing the project structure
```

## Diagram View

```mermaid

flowchart LR
    subgraph subGraph0["Domain Layer"]
        direction LR
        aggregate["Aggregate"]
        domain["Domain"]
        model["Model"]
        entity["Entity"]
        valueobject["Value Object"]
        domain_service["Domain Services"]
        factory["Factories"]
        domain_event["Domain Events"]
        specification["Specifications"]
        exception["Exceptions"]
    end
    subgraph subGraph1["Application Layer"]
        direction LR
        application["Application"]
        use_case["Use Cases"]
        port_in["Input Port"]
        ports["Ports"]
        command["Commands"]
        query["Queries"]
        repositories["Repositories"]
        port_out["Output Port"]
        dto["DTOs"]
        request["Request DTOs"]
        response["Response DTOs"]
        mapper["Mappers"]
    end
    subgraph subGraph2["Adapter Layer"]
        direction LR
        adapter["Adapter"]
        adapter_in["Input Adapters"]
        rest["REST Controllers"]
        message_listeners["Messaging Listeners"]
        adapter_out["Output Adapters"]
        db_impl["Database Implementations"]
        message_producers["Message Producers"]
        api_clients["API Clients"]
    end
    subgraph subGraph3["Infrastructure Layer"]
        direction LR
        infrastructure["Infrastructure"]
        config["Configurations"]
        util["Utilities"]
    end
    subgraph subGraph4["Shared Layer"]
        direction LR
        shared["Shared"]
        shared_event["Event System"]
        shared_error["Error Handling"]
        shared_constants["Constants"]
        shared_utilities["Shared Utilities"]
    end

%% Domain layer relations
    domain --> model --> aggregate & valueobject & domain_service & factory & domain_event & specification & exception
    aggregate --> entity
%% Application layer relations
    application --> ports & dto & mapper
    ports --> port_in & port_out
    port_in --> use_case
    port_out --> repositories
    use_case --> command & query
    dto --> request & response
%% Adapter layer relations
    adapter --> adapter_in & adapter_out
    adapter_in --> rest & message_listeners
    adapter_out --> db_impl & message_producers & api_clients
%% Infrastructure layer relations
    infrastructure --> config & util
%% Shared layer relations
    shared --> shared_event & shared_error & shared_constants & shared_utilities
%% Root relations
    src["main/java/src/com/bmc/anvil/appname"] --> readme["README.md (Documentation)"] & subGraph0 & subGraph1 & subGraph2 & subGraph3 & subGraph4

```
