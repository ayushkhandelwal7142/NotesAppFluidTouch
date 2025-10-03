📒 Notes App (Fluid Touch Clone)
📌 Overview

This is a Notes App built with Jetpack Compose following Clean Architecture principles.
The app allows users to add and manage covers and papers for their notes. Users can select from predefined lists of covers and papers, search across them, and visualize their selections in a clean and intuitive UI.

The project demonstrates:

Modern Android development best practices

MVVM architecture with a domain layer

StateFlow for reactive UI updates

Dialog with tabbed selection for adding items

Search functionality with live filtering

Modular design for scalability and testability

✨ Features

📌 Home Screen

Displays a list of added Covers and Papers in horizontal LazyRows.

Top bar with Add and Search actions.

➕ Add Item Dialog

Popup dialog with tabs (Covers / Papers).

Grid layout to choose an item.

Selected item is added to the respective list in Home.

🔍 Search Functionality

Activates search bar on top when clicking search.

Filters both Covers and Papers dynamically based on query.

Uses domain FilterItemsUseCase for clean separation of concerns.

🗂 Architecture

Clean Architecture layers:

Domain Layer: Business logic encapsulated in UseCases (UpdateCoversUseCase, UpdatePapersUseCase, FilterItemsUseCase).

Presentation Layer: HomeViewModel managing state with StateFlow.

UI Layer: Jetpack Compose screens (HomeScreen, AddItemPopUp, CoversRow, PapersRow, etc).

MVVM pattern for separation of concerns and testability.

🛠 Modern Android Tools

Jetpack Compose for declarative UI.

Kotlin Coroutines & StateFlow for reactive state management.

Hilt / ViewModel Factory for dependency injection (configurable).

Material 3 Components for UI consistency.

🏗️ Tech Stack

Language: Kotlin

UI: Jetpack Compose (Material 3)

Architecture: MVVM + Clean Architecture

State Management: Kotlin Coroutines, StateFlow, Flow operators

Dependency Injection: Hilt (or custom ViewModelFactory)

Build System: Gradle (KTS recommended)

📂 Project Structure
com.practice.notesappfluidtouch
│
├── domain
│   └── usecase
│       ├── FilterItemsUseCase.kt
│       └── HomeDataRepository.kt
│
├── presentation
│   ├── model
│   │   └── Items.kt
│   ├── ui
│   │   ├── HomeScreen.kt
│   │   ├── AddItemPopUp.kt
│   │   └── components (cards, rows, dialogs)
│   └── viewModel
│       ├── HomeViewModel.kt
│       └── HomeViewModelFactory.kt

Clone the repository:

git clone https://github.com/yourusername/notesapp-fluidtouch.git
