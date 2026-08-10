# Java Computer Networks

I'm learning Computer Networks by implementing networking concepts in Java.

The project will be developed step-by-step, with each version introducing a new Computer Networks concept.

## Version 1 - Basic TCP Client-Server

### Concepts Learned

- IP address
- Port number
- TCP
- Client-server architecture
- Socket
- ServerSocket
- InputStream
- OutputStream
- BufferedReader
- PrintWriter
- Blocking I/O

### Current Functionality

The client connects to the server using TCP and sends:

1. Client name
2. Client message

The server receives both and sends a response back.

### Architecture

Client → TCP Socket → Server

### Technologies

- Java
- TCP/IP
- Java Sockets

## How to Run

Start the server first:

```bash
javac Server.java
java Server
