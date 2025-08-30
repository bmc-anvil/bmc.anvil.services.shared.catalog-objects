This folder contains the core **domain models** used in business operations.

## Subfolders

- `aggregate`: Contains **aggregate root objects** responsible for managing tightly related domain objects consistently.
- `entity`: Contains **entities** representing domain objects with a unique identity, but not aggregate roots.
- `valueobject`: Contains **value objects**, which are immutable and model concepts without unique identity.
