# ChatBot Project

This is a ChatBot project implemented in Java. The ChatBot interacts with the user through a graphical user interface (GUI) and provides responses to user queries or commands.

## Features

- The ChatBot can answer general questions, questions related to the Java programming language, or any other topic.
- The ChatBot provides a welcome message and instructions on how to use it.
- Users can ask questions such as the current time, date, or request to clear the chat screen.
- The ChatBot utilizes a JSON file (`chatbotQNA.json`) to store question-answer pairs for predefined responses.
- If the user's query matches a question in the JSON file, the ChatBot provides the corresponding answer.
- If the user's query is not found in the JSON file, the ChatBot performs a web search using Google and displays the search results.
- The ChatBot handles exceptions, such as no internet connection or invalid input.

## Prerequisites

To run this project, you need to have the following:

- Java Development Kit (JDK) installed on your machine.
- A Java Integrated Development Environment (IDE) such as Eclipse or IntelliJ IDEA.

## Getting Started

1. Clone the project repository to your local machine.
2. Open the project in your preferred Java IDE.
3. Make sure the required Gson library is added to the project build path. You can download the Gson library from the [Gson GitHub repository](https://github.com/google/gson) or use a dependency management tool like Maven or Gradle.
4. Compile and run the `Bot.java` file to start the ChatBot.

## Usage

Once the ChatBot GUI is displayed, you can interact with it by typing messages in the chatbox at the bottom of the window and pressing Enter. The ChatBot will display responses in the chat area above.

Sample commands you can try:
- "Hi" or "Hello": The ChatBot will greet you and ask how it can help.
- "How are you?": The ChatBot will respond positively and ask how it can assist you.
- "What can you do?": The ChatBot will provide a list of sample questions you can ask.
- "Time": The ChatBot will display the current time.
- "Date": The ChatBot will display the current date.
- "Clear screen" or "Clear chat": The ChatBot will clear the chat area.
- Any other question or input: The ChatBot will try to provide an answer based on the predefined question-answer pairs in the JSON file. If no answer is found, the ChatBot will perform a web search using Google and display the search results.

## Customization

You can customize the ChatBot by modifying the JSON file (`chatbotQNA.json`) to add more question-answer pairs or modify existing ones. Make sure to follow the JSON format structure for each entry:

```json
{
  "question": "Your question here",
  "answer": "The corresponding answer to the question"
}
```

## Limitations

- The ChatBot relies on predefined question-answer pairs stored in the JSON file. If a user asks a question that is not in the JSON file and a web search is performed, the ChatBot may not always provide accurate or relevant results.
- The ChatBot does not have the capability to learn or adapt based on user interactions.

## Acknowledgments

This ChatBot project was created by Hardik Chopra as a project for Caelius Consulting Pvt. Ltd. It utilizes the Gson library for JSON parsing and handling.
