This folder orchestrates **application-specific workflows** and **use cases** by coordinating domain objects.

## Subfolders

- `port`: Defines boundaries and interfaces between the application and external systems.
- `usecase`: Implements application workflows for handling the different ports.
  - this follows uncle Bob's approach where use cases have code
- `dto`: Data Transfer Objects (DTOs) used for communication.
- `mapper`: Logic for mapping domain objects to DTOs and vice versa.
