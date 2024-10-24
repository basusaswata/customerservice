Build Deployment Artifact Workflow
This repository contains a GitHub Actions workflow for automating the build, analysis, and deployment process for a project. The workflow ensures secure deployment and generates supply chain security evidence such as SBOMs, provenance attestations, and signature verifications.

Overview
This workflow includes:

Build and Deployment:
Set up the Java environment with JDK 11.
Perform a Maven build.
Build and push Docker images.
Security and Compliance:
Secret scanning to detect sensitive information in the codebase.
Software Composition Analysis (SCA) to detect vulnerabilities in dependencies.
Generate Software Bill of Materials (SBOM) and signed provenance for both the source code and Docker images.
Supply Chain Security:
Provenance generation for container and source artifacts.
Signature verification and attestation for both source and container BOM.
Verification of Git branch protection, ensuring no direct commits to the main branch without appropriate approvals.
Prerequisites
A GitHub repository with appropriate branch protection rules enabled.
Secrets configured in the repository settings:
CLIENT_SECRET: Client secret for validating artifacts.
GITH_TOKEN: GitHub token for API interactions.
DOCKPAS: Docker Hub password for pushing images.
How to Trigger the Workflow
This workflow can be manually triggered using GitHub's workflow_dispatch event. It is designed for flexibility and can be extended to run on every push to specific branches.

Workflow Steps
1. Setup and Checkout
The workflow checks out the codebase from the repository.
The Java environment is set up with Temurin JDK 11 for building the project.
2. Secret Scanning and SCA
A secret scanning action is run to detect any sensitive information in the codebase.
Software composition analysis (SCA) is performed to analyze dependencies for vulnerabilities, producing a JSON report.
3. Evidence Generation
Generates SBOMs and provenance statements using Valint for both source code and Docker images.
Uploads the generated SBOMs and provenance statements as artifacts.
4. Build and Push Docker Image
The Maven build is run to package the application.
A Docker image is built from the project and pushed to Docker Hub.
5. Verification and Signature Attestation
Verifies the generated provenance and attestation signatures for source and container artifacts.
Ensures branch protection rules are enforced, requiring two approvers for pull requests.
Artifact Uploads
The workflow uploads the following artifacts:

Source SBOM and provenance.
Container SBOM and provenance.
SCA results.
Source and container attestation signatures.
Example Secrets Configuration
Ensure that the following secrets are set in your repository settings:

CLIENT_SECRET: Used for artifact verification and attestation.
GITH_TOKEN: GitHub API token for querying pull request details.
DOCKPAS: Docker Hub credentials for pushing the Docker image.
Conclusion
This GitHub Actions workflow provides an end-to-end build, security analysis, and deployment process, ensuring compliance with secure software supply chain practices through automated generation of SBOMs and provenance attestations.

For further information, visit Scribe Security or check out the Open Policy Agent used in this workflow.
