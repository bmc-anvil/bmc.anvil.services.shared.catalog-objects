#!/bin/bash

# Define the application name and root folder
APP_NAME="catalog"
ROOT_DIR="../src/main/java/com/bmc/anvil/$APP_NAME"

# Define the path for the README templates
TEMPLATE_PATH="readme_templates"

# Array of folders to create
FOLDER_STRUCTURE=(
  # Domain-related folders
  "$ROOT_DIR/domain/model/aggregate"
  "$ROOT_DIR/domain/model/entity"
  "$ROOT_DIR/domain/model/valueobject"
  "$ROOT_DIR/domain/factory"
  "$ROOT_DIR/domain/service"
  "$ROOT_DIR/domain/event"
  "$ROOT_DIR/domain/exception"
  "$ROOT_DIR/domain/specification"

  # Application-related folders
  "$ROOT_DIR/application/ports/in"
  "$ROOT_DIR/application/ports/out/repositories"
  "$ROOT_DIR/application/usecase/command"
  "$ROOT_DIR/application/usecase/query"
  "$ROOT_DIR/application/dto/request"
  "$ROOT_DIR/application/dto/response"
  "$ROOT_DIR/application/mapper"

  # Adapter layer folders
  "$ROOT_DIR/adapter/in/rest"
  "$ROOT_DIR/adapter/in/messaging"
  "$ROOT_DIR/adapter/out/database"
  "$ROOT_DIR/adapter/out/messaging"
  "$ROOT_DIR/adapter/out/api"

  # Infrastructure and shared folders
  "$ROOT_DIR/infrastructure/config"
  "$ROOT_DIR/infrastructure/util"
  "$ROOT_DIR/shared/event"
  "$ROOT_DIR/shared/error"
  "$ROOT_DIR/shared/constants"
  "$ROOT_DIR/shared/utils"
)

# Function to create folders
create_folders() {
    echo "Creating folder structure..."
    for folder in "${FOLDER_STRUCTURE[@]}"; do
        mkdir -p "$folder"  # Create folder and all intermediate directories
        echo "Created: $folder"
    done
    echo "Folder structure created successfully."
}

# Function to create README.md files from templates
create_readme() {
    folder_path="$1"
    template_file="$2"

    # Check if the template file exists
    if [[ ! -f "$template_file" ]]; then
        echo "Template file not found: $template_file"
        return
    fi

    # Copy the contents of the template file into README.md
    cp "$template_file" "$folder_path/README.md"
    echo "Generated README.md for $folder_path from $template_file"
}

# Function to associate folders with README templates
generate_readme_files() {
    echo "Generating README.md files..."

    declare -A README_FILES=(
        ["$ROOT_DIR"]="main.md"
        ["$ROOT_DIR/domain"]="domain.md"
        ["$ROOT_DIR/domain/model"]="domain_model.md"
        ["$ROOT_DIR/domain/factory"]="domain_factory.md"
        ["$ROOT_DIR/domain/service"]="domain_service.md"
        ["$ROOT_DIR/domain/event"]="domain_event.md"
        ["$ROOT_DIR/domain/specification"]="domain_specification.md"
        ["$ROOT_DIR/domain/exception"]="domain_exception.md"
        ["$ROOT_DIR/application"]="application.md"
        ["$ROOT_DIR/application/ports"]="application_ports.md"
        ["$ROOT_DIR/application/usecase"]="application_use_case.md"
        ["$ROOT_DIR/application/dto"]="application_dto.md"
        ["$ROOT_DIR/application/mapper"]="application_mapper.md"
        ["$ROOT_DIR/adapter"]="adapter.md"
        ["$ROOT_DIR/adapter/in"]="adapter_in.md"
        ["$ROOT_DIR/adapter/out"]="adapter_out.md"
        ["$ROOT_DIR/infrastructure"]="infrastructure.md"
        ["$ROOT_DIR/shared"]="shared.md"
    )

    # Iterate over the README_FILES and create README.md for each folder
    for folder in "${!README_FILES[@]}"; do
        template_file="$TEMPLATE_PATH/${README_FILES[$folder]}"

        # Ensure the folder exists before creating its README.md
        mkdir -p "$folder"
        create_readme "$folder" "$template_file"
    done

    echo "All README.md files have been created successfully."
}

# Main script execution
create_folders
generate_readme_files
