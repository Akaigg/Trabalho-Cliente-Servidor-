import socket

HOST = 'localhost'
PORT = 12345

server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
server.bind((HOST, PORT))
server.listen()

print("Servidor aguardando conexão...")

conn, addr = server.accept()
print("Conectado por:", addr)

data = conn.recv(1024).decode()

try:
    base, altura = data.split(",")
    base = float(base)
    altura = float(altura)

    area = (base * altura) / 2
    resposta = f"Área: {area:.2f}"

except:
    resposta = "ERRO: entrada inválida"

conn.send(resposta.encode())

conn.close()
server.close()
