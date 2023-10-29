# Android chat

In this repository, we have created an Android app for a chat system. This is the client side. You can find the server side [here](https://github.com/adi-ben-yehuda/Server)

The application contains the following screens:
- Login screen
- Registration screen
- contacts screen
- Chat screen
- Added a new contact
- settings

## General Information
The main page displays a simple login screen where the user is required to enter a username and password or navigate to the registration screen.

![image](https://github.com/danadanile/andoid_Web/assets/75027826/93b2b1bb-cc3f-4a05-928f-e0aad19ab965)

On the registration screen, the customer needs to enter their username, password, display name, and upload a photo. The input fields are validated with the following requirements: all fields are mandatory, the password must have at least 8 characters and the username must be unique.

![image](https://github.com/danadanile/andoid_Web/assets/75027826/c559d90e-a1a0-4e81-8082-bd7ee82fc682)

After registration, the user can log in to the application by entering his username and password. If the details are correct, the user will be redirected to the contacts screen. 

On the Contacts screen, all of the user's contacts are displayed. The user can click on a specific contact and the chat with him will be displayed.

![image](https://github.com/danadanile/andoid_Web/assets/75027826/6b4bcdfd-2a86-46b4-a5b4-62c60d3be96f)

On the chat page, the user can see all the message history with the specific contact. The user can also send him a new message.

![image](https://github.com/danadanile/andoid_Web/assets/75027826/48415166-64f8-4892-88ae-b227ecadc675)

From the Contacts page, the user can add a new contact using the Add button and navigate to the Add Contact page. On this page, the user enters the username they want to add and clicks Add. On the Contacts page, the new contact will be displayed.

![image](https://github.com/danadanile/andoid_Web/assets/75027826/75b30b76-9de2-4c0d-b0bb-fb29741ab8fe)

There is also a settings option on the login page and the contacts page. On the settings page, the user can change the address of the server to which the application is connected or the color theme of the application.

![image](https://github.com/danadanile/andoid_Web/assets/75027826/7bcefda2-162c-4b08-a5e3-d7c5f34cc941)

In our Android app, we keep a local copy of the chats and messages.
When the application is opened, the information is pulled from the local SQLite DB using Room. After the server returns the updated information to us via the API, the local DB is updated.

The app also includes notification functionality via Firebase. After the user is logged in and another user sends a message to him, a notification will be displayed. The notification includes the name of the sender and the content of the message.
If the user is not currently active, the notification will be displayed the next time the application is launched.

## Installation

Before installing this project, you need to install on your computer:

- Git
- Android Studio

Then open a terminal and clone the project:
```
git clone https://github.com/adi-ben-yehuda/android_chat.git
```

And run the app.
