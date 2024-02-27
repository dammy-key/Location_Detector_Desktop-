# Location Detector Desktop

Location Detector Desktop is a JavaFX application named `software` that simulates location changes and checks phone numbers. It provides a responsive user interface for both desktop and mobile views.

## Prerequisites

- Java 8 or later
- JavaFX library (included in Java 8 and later)

## How to Run

1. Make sure you have Java installed on your machine.

2. Clone the repository:

    ```bash
    https://github.com/dammy-key/Location_Detector_Desktop-.git
    ```

3. Navigate to the project directory:

    ```bash
    cd Location_Detector_Desktop-
    ```

4. Compile and run the application:

    ```bash
    javac --module-path /path/to/javafx-sdk-17/lib --add-modules javafx.controls app.java
    java --module-path /path/to/javafx-sdk-17/lib --add-modules javafx.controls app
    ```

   Replace `/path/to/javafx-sdk-17` with the actual path to your JavaFX SDK.

## Usage

- **Simulate Location Change:** Click the "Simulate Location Change" button to simulate a location change. If your location is not available or visible, a warning message will be displayed.

- **Check Phone Number:** Enter a phone number in the provided field and click the "Check Phone Number" button. If the phone number is not valid (empty in this example), an error message will be displayed.

- **Contact DammyTech:** Click the "Contact DammyTech" link to open DammyTech's contact page in your default web browser. or via mail "petersdamilare5@gmail.com"

## Responsive Design

The application provides a responsive user interface that adapts to both desktop and mobile views. The font sizes and styles are adjusted based on the screen size.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details.

## Acknowledgments

- [JavaFX](https://openjfx.io/)
- [DammyTech](https://dammytech.netlify.app)


