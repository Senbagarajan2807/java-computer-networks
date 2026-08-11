# Java Computer Networks

I'm learning **Computer Networks by implementing networking concepts in Java**.

This project is being developed step-by-step. Each version introduces a new Computer Networks concept and extends the previous implementation.

---

## Project Structure

```text
java-computer-networks/
│
├── v1-basic-tcp/
│   ├── Client.java
│   └── Server.java
│
├── v2-multiple-clients/
│   ├── Client.java
│   ├── ClientHandler.java
│   └── Server.java
│
├── v3-broadcast/
│
├── v4-advanced/
│
├── final/
│
├── .gitignore
└── README.md
```

---

# Version 1 - Basic TCP Client-Server

## Concepts Learned

- IP Address
- Port Number
- TCP
- Client-Server Architecture
- Socket
- ServerSocket
- InputStream
- OutputStream
- BufferedReader
- PrintWriter
- Blocking I/O

## Functionality

The client connects to the server using TCP and sends:

1. Client name
2. Client message

The server receives both and sends a response back.

## Architecture

```text
Client
   |
   | TCP Connection
   ↓
Server
```

## Technologies

- Java
- TCP/IP
- Java Sockets

---

# Version 2 - Multiple Clients

## Concepts Learned

- Multiple TCP Clients
- Threads
- Runnable
- Concurrent Client Handling
- Client Handler
- ServerSocket `accept()`
- Blocking I/O
- Thread-per-client Architecture

## What Changed?

In Version 1, the server handles a single client connection.

In Version 2, the server can accept multiple clients.

Whenever a client connects, the server creates a new `ClientHandler` and assigns it to a separate thread.

```text
Server
   |
   | accept()
   ↓
Client Socket
   |
   ↓
ClientHandler
   |
   ↓
New Thread
```

## Architecture

```text
                    SERVER
                       |
                  ServerSocket
                       |
                    accept()
                       |
          ┌────────────┼────────────┐
          ↓            ↓            ↓
       Thread 1     Thread 2     Thread 3
          ↓            ↓            ↓
       Client 1     Client 2     Client 3
```

## Functionality

Multiple clients can connect to the same server simultaneously.

Example:

```text
Server
 ├── Client 1 → Thread 1
 ├── Client 2 → Thread 2
 └── Client 3 → Thread 3
```

The server continuously waits for new connections using:

```java
while (true) {
    Socket socket = serverSocket.accept();

    ClientHandler clientHandler = new ClientHandler(socket);

    Thread thread = new Thread(clientHandler);
    thread.start();
}
```

## Why Threads?

Without threads, the server would have to finish handling one client before accepting another client.

With threads, each client can be handled independently:

```text
Client 1 → Thread 1
Client 2 → Thread 2
Client 3 → Thread 3
```

---

# How to Run

## Version 1

Navigate to the version folder:

```bash
cd v1-basic-tcp
```

Compile:

```bash
javac *.java
```

Start the server:

```bash
java Server
```

Then open another terminal and start the client:

```bash
java Client
```

---

## Version 2

Navigate to the version folder:

```bash
cd v2-multiple-clients
```

Compile:

```bash
javac *.java
```

### Start Server

```bash
java Server
```

Keep the server running.

### Start Client 1

Open another terminal:

```bash
java Client
```

### Start Client 2

Open another terminal:

```bash
java Client
```

### Start Client 3

Open another terminal:

```bash
java Client
```

Multiple clients can now connect to the same server.

---

# Learning Roadmap

```text
V1
Basic TCP Client-Server
        ↓
V2
Multiple Clients + Threads
        ↓
V3
Broadcasting Messages
        ↓
V4
Advanced Networking Concepts
        ↓
Final
Mini Networking System
```

---

# Technologies

- Java
- TCP/IP
- Java Sockets
- Multithreading
- Git
- GitHub

---

# Goal

The goal of this project is to understand **Computer Networks practically** rather than only studying the theory.

Each version will introduce a new networking concept and build upon the previous version.
