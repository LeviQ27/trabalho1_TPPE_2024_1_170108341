# Versionamento

| Versão | Data         | Descrição                           | Autor         |
|--------|--------------|-------------------------------------|---------------|
| 1.0.0  | 2024-07-07   | Entrega TP1                         | Levi Queiroz  |
| 1.1.0  | 2024-08-26   | Entrega TP2                         | Levi Queiroz  |
| 1.2.0  | 2024-08-26   | Entrega TP3                         | Levi Queiroz  |


# Sumário

[1 - Trabalho 1](#trabalho-1-de-tecnicas-de-programacao-em-plataformas-emergentes)

[2 - Trabalho 2](#trabalho-2-refatoracao)

[3 - Trabalho 3](#trabalho-3-bom-projeto-de-software)

# Trabalho 1 de Técnicas de Programação em Plataformas Emergentes

O aluno Levi de Oliveira Queiroz, da matrícula 170108341, criou e editou este repositório com o objetivo de realizar a criação de classes para uma empresa de comércio varejista através de técnicas de TDD. De modo que cumprisse os critérios apresentados no enunciado do trabalho. O esquema de arquivos de testes e classes criados é apresentado na figura a seguir:

![Captura de tela de 2024-07-07 20-34-29.png](https://drive.google.com/uc?export=view&id=1ZjEwTE_9ff6O9b69_AZo3DypCcN_9hRe)

>Figura 1: Captura de tela da árvore de arquivos da pasta trabalho1  Autor: Autoria Própria

E assim ficou os testes ao rodar a suite de testes:

![Captura de tela de 2024-07-07 21-05-13.png](https://drive.google.com/uc?export=view&id=1ClbkqO9hovqZQvO2-V18adsOG4QqrYIA)

>Figura 2: Primeira captura de tela da suite de testes  Autor: Autoria Própria

![Captura de tela de 2024-07-07 21-05-47.png](https://drive.google.com/uc?export=view&id=1QOMZFH6Sq0zzH96PFT58pdNDN_2dCNEz)

>Figura 3: Segunda captura de tela da suite de testes  Autor: Autoria Própria


# Enunciado Trabalho 1 de Técnicas de Programação em Plataformas Emergentes

Seja o seguinte cenário de uma aplicação a ser desenvolvida utilizando a técnica
de Desenvolvimento Guiado por Testes. 

> [Cenário]
> Uma empresa de comércio varejista de bens de consumo classifica os seus
> clientes como padrão, especiais (para aqueles que têm compras mensais acima de
> R$100,00 e prime) (para aqueles que pagam uma mensalidade no valor de R$20,00).
> 
> Os clientes especiais têm como benefício o desconto de 10% sobre o valor total
> da compra. Eles podem ainda receber mais 10% de desconto sobre o valor total
> do pedido, caso este seja pago utilizando o cartão de crédito da empresa.
> Cartões de crédito da empresa são identificados por começarem sempre com os
> algarismos 4296 13XX XXXX XXXX (X são valores não considerados na
> identificação do cartão da empresa). Clientes especiais ainda possuem um
> desconto de 30% no valor do frete. 
> 
> Os clientes Prime possuem isenção no valor do frete e recebem como _cashback_
> o valor de R$0,03 a cada real gasto na loja. Caso a compra tenha sido paga
> através do cartão de crédito da loja, o valor de cashback para cada real gasto
> é de R$0,05. Os valores acumulados como _cashback_ podem ser utilizados como
> descontos em compras. 
> 
> Para cada compra realizada é necessário calcular o ICMS e o imposto municipal.
> A empresa é sediada no DF e, por isso, aplica-se as seguintes taxas para os
> impostos: 
> - 12% de ICMS e 4% de imposto municipal em vendas para clientes fora do DF;
> - 18% de ICMS e 0% de imposto municipal em vendas para cliende do DF. 
> 
> Os fretes são calculados com base na tabela a seguir: 
> |                   | Capital  | Interior | 
> |-------------------|----------|----------|
> |Distrito Federal   | R$  5,00 |          |
> |Regiao Centro-oeste| R$ 10,00 | R$ 13,00 |
> |Regiao Nordeste    | R$ 15,00 | R$ 18,00 |
> |Regiao Norte       | R$ 20,00 | R$ 25,00 |
> |Regiao Sudeste     | R$  7,00 | R$ 10,00 |
> |Regiao Sul         | R$ 10,00 | R$ 13,00 |
> 
> Na impressão da nota fiscal é necessário que seja informado os valores dos
> impostos ICMS e municipal para cada item, de modo que o valor total dos
> impostos seja a soma do valor dos impostos de cada item. Os descontos,
> conforme o tipo de cada cliente, deverão também constar na nota fiscal. 

## Enunciado

Instruções gerais: 
- Os trabalhos deverão ser realizados em grupos de no máximo 4 alunos. 
- Os grupos deverão informar seus componentes e o endereço do repositório do
  trabalho no seguinte formulário
  [https://docs.google.com/forms/d/e/1FAIpQLSfzotcXeM93nI_YcSWeB2YntYn7Q1vMJaN3dtUlMwnhZJ245A/viewform](https://docs.google.com/forms/d/e/1FAIpQLSfzotcXeM93nI_YcSWeB2YntYn7Q1vMJaN3dtUlMwnhZJ245A/viewform)
- :warning: ATENÇÂO: os trabalhos deverão **obrigatoriamente** ser desenvolvidos
  em Java e JUnit 4. Outras linguagens e frameworks de testes não serão aceitas
e terão zero atribuído às suas notas. 

### Trabalho 1: TDD
Utilizando as técnicas de TDD, crie um programa que seja capaz de realizar as
seguintes ações: 
- Cadastrar clientes dos três diferentes tipos (padrão, especial e prime), com
  seus endereços de entrega em diferentes regiões do pais. Por simplicidade,
considere apenas o estado e informe se o endereço é na capital ou no interior. 
- Cadastrar diferentes tipos de produtos. Para cada produto deverá ser
  informado:
  - Codigo do item
  - Descricao
  - Valor de venda
  - Unidade (peça, unidade, metro, cm3, etc...)
- Realizar a venda de itens para os clientes. A venda consiste em uma data,
  cliente, itens vendidos e método de pagamento. Além disso serão calculados,
para cada venda em específico, o valor do frente e os descontos (caso haja),
além dos impostos ICMS e municipal. Se for uma venda para um cliente prime, este
poderá utilizar seu saldo de cashback para abater na compra. 
- Calcular o valor das vendas do ultimo mês para cada cliente e verificar se ele
  é elegível para ser considerado como um cliente especial. 
- Calcular o saldo de cashback para clientes-prime. 

Cada um desses itens deve ser desenvolvido através de TDD de modo que deve haver
pelo menos um caso de teste para cada. No caso de haver mais de um caso de teste
para cada item, os casos de testes que o implementam deverão estar agrupados em
uma suíte de testes. 

:warning: **ATENÇÃO:** todos os testes deverão ser triangulados utilizando a
**parametrização** de testes oferecida pelo JUnit4.

## Critérios 

### Trabalho 1: TDD
- Todos os itens do enunciado foram implementados? 
- O programa é correto?
- Todos os testes foram implementados utilizando parametrização de testes?
- Todos os testes rodam sem erros?

# Trabalho 2: Refatoração

Neste presente trabalho foi realizado as operações de refatoração sugeridas pelos professor. De acordo, foi produzido os seguintes resultados, sem falha no testes:

![Captura de tela 4](https://drive.google.com/file/d/1Z97gyEQM2yfENgSsOZTVM_5wiY3XPNdl/view?usp=sharing)

>Figura 4: Captura de tela das classe criadas após refatoração  Autor: Autoria Própria

![Captura de tela 5](https://drive.google.com/file/d/1Ruip1QtyP8sTIiUaDBKWV2IN2NFMOgPE/view?usp=sharing)

>Figura 5: Captura de tela da classe calculoCliente criada após refatoração  Autor: Autoria Própria

![Captura de tela 6](https://drive.google.com/file/d/1Ruip1QtyP8sTIiUaDBKWV2IN2NFMOgPE/view?usp=sharing)

>Figura 6: Captura de tela da classe calculoDescontoVenda após refatoração  Autor: Autoria Própria

Ainda, dentro da classe Venda tem-se, em comentário, a refatoração por Extração de Método no método `calcularValorTotal()`.


# Enunciado Trabalho 2 de Técnicas de Programação em Plataformas Emergentes

A segunda parte do trabalho consiste na aplicação de operações de Refatoração no
código entregue pelos grupos na primeira parte. Todos os grupos aplicarão as
mesmas operações de Refatoração em seus trabalhos. As operações serão aplicadas
nas classes / métodos indicados pelo professor para cada grupo. Ao final das
operações de Refatoração, os grupos deverão apresentar como comentários no
código uma descrição detalhada dos efeitos da operação de refatoração no código. 

##### Lista de refatorações por grupos e seus locais de aplicação:

|-------|-------------------------------------|-------------------------|
|  23   | Extrair método                      | Venda::calcularValorTotal() |
|       | Extrair classe                      | Cliente                 |
|       | Substituir método por objeto-método | Venda::calcularDesconto() |
|-------|-------------------------------------|-------------------------|

## Critérios

### Trabalho 2: Refatoração
Data limite: 14/8/2024. Trabalhos entregues posteriormente serão penalizados com
um desconto de 50% na nota.

# Trabalho 3: Bom Projeto de Software

Assim, o trabalho 3 de TPPE foi realizar um estudo de boas práticas de projeto de software em relação ao processo de refatoração descrita por Martin Fowler. Foi pedido a entrega de um documento PDF que é apresentado a seguir e encontrado támbem em [TP3 - Avaliação e Análise do Projeto Realizado para a Matéria de Técnicas de Programação em Plataformas Emergentes](/trabalho1/assets/tp3_170108341_Levi.pdf):

<iframe src="https://drive.google.com/file/d/12J2SRQhM5jdryIQ60_0zuVq-flViFuKI/preview" width="640" height="480" allow="autoplay"></iframe>

# Enunciado do Trabalho 3 de Técnicas de Programação em Plataformas Emergentes

Projeto de software é, muitas vezes, entendido como uma atividade dentro do
processo de desenvolvimento em que uma equipe define as estruturas do software e
as interações entre elas. O intuito com esse tipo de abordagem é facilitar o
desenvolvimento à partir dos artefatos gerados durante a atividade de projeto.
Os artefatos gerados servem como uma especificação do que o software deve fazer
e quais as propriedades que devem ser garantidas quando ele estiver em operação.

Contudo, a realidade é diferente. O código é também uma atividade de projeto de
software. Basta relembrar do conceito de Refatoração. Martin Fowler, em seu
livro de refatoração, define como sendo "_o aperfeiçoamento do **projeto** de
código sem alterar o seu comportamento externamente observável._"(Fowler, 1999).
Por mais detalhado que sejam os artefatos de software criados durante a
atividade de projeto de software, eles não conseguirão capturar todos os
detalhes que são considerados durante a codificação. Os menores detalhes
escapam dos modelos gerados e, geralmente, são descobertos durante a atividade
de codificação sob a forma de inconsistências, falhas ou erros. Disso segue um
conceito-chave muito importante: 

> Conceito chave:  
> Programar é uma atividade de projeto de software. 

Portanto, são os programadores quem refinam e extendem o projeto de software na
medida em que, constantemente, várias vezes ao dia, refinam e extendem o código
da aplicação. Isso não significa que a idéia inicial de um projeto deva ser
descartada. Pelo contrário, ter em mente o projeto que se deseja alcançar é
importante, pois ele se torna uma meta a ser alcançada. Essa meta de projeto
deve ser minimamente coerente para que o projeto resultante não se transforme em
um projeto desestruturado e de difícil manutenção e evolução. 

## Projeto de software

Desenvolvedores, em suas funções, realizam atividades de projeto de código, como
classes, objetos e estruturas de dados. Essas pequenas contribuições vão sendo
incorporadas ao projeto do software na medida em que são desenvolvidas. Em
escala ascendente, os níveis de projeto de software são:  
- funções: nível mais elementar das atividades de projeto, mas não menos
  importante. Se as rotinas são projetadas sem cuidado todo o sistema será
  impactado. Uma vez definido quais são as funções necessárias, trabalha-se na
  implementação interna, definindo algoritmos e o fluxo de execução. 
- classes e tipos de dados: após a definição das funções, as atividades de
  codificação que resultam em alterações no projeto concentram-se nas definições
  de interfaces para utilização dessas funções. Nesse nível busca-se projetar
  interfaces que sejam representem o conjunto das funções encapsuladas. Isso se
  dá, no contexto de orientação a objetos, por meio da definição de classes e
  interfaces. 
- módulos e componentes: o passo seguinte é organizar as classes desenvolvidas
  em conjunto de classes, compreensíveis, que guardem alguma relação de
  similaridade ou proximidade entre si. Costuma-se chamar esses agrupamentos de
  módulos ou componentes, contudo, é necessário atentar-se ao que se entende por
  módulos. Por exemplo, pode ser considerado como um conjunto de classes em
  linguagens orientadas por objetos ou como bibliotecas em linguagens
  procedurais. Nesse ponto do projeto o que se busca é a definição de interfaces
  **publicadas**, as quais deverão ser estáveis pois desempenham o papel de
  contratos entre os módulos e entre as equipes que trabalham nelas. 
- arquitetura do sistema: nesse ponto observa-se o sistema e seus subsistemas
  como um todo. O projeto arquitetural desempenha forte influência no desempenho
  e nas características do sistema como um todo. 

O projeto de software é a base sobre a qual todo o software será construído, uma
vez que essa base é bem projetada e estruturada aumentam-se as chances do
software construído ter qualidade. São características de um bom projeto de
software: 
- fácil de escrever; 
- fácil de entender; 
- fácil de manter; 
- menos provável de ter bugs e, por fim,
- mais resiliente à mudanças.

Tudo isso exposto, conclui-se que ter um projeto de software correto,
principalmente desde o início, é muito importante. É possível pensar em
características de bom projeto em nível micro, durante a codificação, de modo
que as boas práticas se acumularão e terão impactos no projeto do software como
um todo. Vários desses princípios guardam estreita relação com as operações de
refatoração de modo que é possível realizar melhorias em projetos de código
existentes aplicando uma ou uma sequência de operações. Em linhas gerais, os
princípios de um bom projeto de código são: 
- simplicidade; 
- elegância; 
- modularidade; 
- boas interfaces; 
- extensibilidade; 
- evitar duplicação; 
- portabilidade; 
- código deve ser idiomático e bem documentado.

## Enunciado: 

Com base na descrição acima, cada grupo de trabalho deverá responder as
seguintes perguntas: 

1 - Para cada um dos princípios de bom projeto de código mencionados acima,
apresente sua definição e relacione-o com os maus-cheiros de código apresentados
por Fowler em sua obra.

2 - Identifique quais são os maus-cheiros que persistem no trabalho prático 2 do
grupo, indicando quais os princípios de bom projeto ainda estão sendo violados e
indique quais as operações de refatoração são aplicáveis. Atenção: não é
necessário aplicar as operações de refatoração, apenas indicar os princípios
violados e operações possíveis de serem aplicadas. 

## Formato e Data de entrega: 

O trabalho deverá ser entregue na forma de um relatório em PDF, elaborado pelo
grupo. O trabalho será enviado ao repositório já utilizado pelos TPs 1 e 2. As
referências listadas abaixo devem ser consultadas em suas respostas. 


## Referências bibliográficas
- Martin Fowler. Refactoring: Improving the design of Existing Code.
  Addison-Wesley Professional, 1999.
- Pete Goodliffe. Code Craft: The practice of Writing Excellent Code. No Starch
  Press, 2006. 