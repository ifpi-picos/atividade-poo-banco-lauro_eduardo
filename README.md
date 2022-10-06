# POO

## Banco Maut

### Requisitos

- Um conta no banco Maut tem número da agência, número da conta, saldo e um Cliente vinculado;

- Para que um cliente abra uma conta no banco Maut, ele deve informar os seguintes dados: nome, CPF, data de nascimento e endereço;

- Um conta só pode estar vinculada a um cliente, no entanto um cliente pode ter várias contas;

- O sistema deve possibilitar ao cliente ver o saldo de sua conta, depositar, sacar e transferir dinheiro para outra conta;

- Após a criação da conta não pode-se alterar sua agência e nem seu número;

- O CPF do cliente não pode ser alterado;

### Resolver

#### Parte 1
- Ajustar as datas
- Não permitir cadastro de cliente com CPF já existente
- Não permitir criação de conta com número de conta já existente
- Idade mínima para cadastro

#### Parte 2
- O banco Maut solicitou que seu sistema permita aos clientes abrirem contas de dois tipos: corrente e poupança;
- A conta corrente pode ter cheque especial, que é um valor que o cliente pode sacar além do seu saldo;
- A conta corrente permite fazer 2 transferências por mês sem cobrar taxa;
- A conta poupança cobra uma taxa de 5% do valor da transferência para cada transferência realizada;
- A conta poupança tem um rendimento de 10% (porcentagem inicial quando a conta é criada, mas esse valor de rendimento pode variar) em cima do valor de cada depósito;
- Quando o cliente realizar alguma transação de alteração de saldo da conta o sistema deve enviar uma notificação via email ou sms;