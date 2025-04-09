async function saveProduto(event) {
    event.preventDefault();

    try {
        const nome = document.getElementById('nomeInput').value.trim();
        if (!nome) {
            throw new Error('O nome do produto é obrigatório');
        }

        const valor = parseFloat(document.getElementById('valorInput').value);
        if (isNaN(valor)) {
            throw new Error('Valor inválido');
        }

        const saldo = parseInt(document.getElementById('saldoInput').value);
        if (isNaN(saldo)) {
            throw new Error('Saldo inválido');
        }

        const saldomin = parseInt(document.getElementById('saldomin').value);
        if (isNaN(saldomin)) {
            throw new Error('Saldo mínimo inválido');
        }

        const produto = {
            id,
            nome,
            valor,
            saldo,
            saldo
        };

        const response = await fetch("http://localhost:8080/produto", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(produto),
        });


        // status HTTP entre 200-299
        if (!response.ok ) { 
            const errorData = await response.json();
            throw new Error(errorData.message || 'Erro ao salvar produto');
        }

        const data = await response.json();
        console.log('Produto salvo com sucesso:', data);
        
        alert('Produto salvo com sucesso!');
        document.getElementById('produtoForm').reset();
        loadProduto();
        
    } catch (error) {
        console.error('Erro ao salvar produto:', error);
        alert(error.message);
    }
    
}

async function atualizarProduto() {
    const produto = {
        idProduto: document.getElementById('idProduto').value,
        nome: document.getElementById('nome').value,
        valor: document.getElementById('valor').value,
        saldo: document.getElementById('saldo').value,
        saldomin: document.getElementById('saldomin').value
    };

    try {
        const response = await fetch('http://localhost:8080/produto/' + produto.idProduto, {
            method: 'PUT', // ou 'PATCH' se for um update parcial
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(produto)
        });

        if (!response.ok) {
            throw new Error('Erro ao atualizar produto');
        }

        const updatedProduct = await response.json();
        console.log('Produto atualizado:', updatedProduct);
    } catch (error) {
        console.error('Erro:', error);
    }
}

async function loadProduto() {
    try {
        const response = await fetch("http://localhost:8080/produto", {
            method: "GET",
            headers: {
                "Content-Type": "application/json",
            }
        });

        if (!response.ok) {
            throw new Error('Erro ao carregar produtos');
        }

        const produtos = await response.json();
        exibirProdutos(produtos);
        
    } catch (error) {
        console.error('Erro:', error);
    }
}

function exibirProdutos(produtos) {
    const produtosList = document.getElementById('produtosList');
    produtosList.innerHTML = ''; // Limpa qualquer conteúdo existente na lista

    // Cria um HTML para cada produto
    produtos.forEach(produto => {
        const divProduto = document.createElement('div');
        divProduto.classList.add('produto-item');
        divProduto.innerHTML = `
            <p><strong>ID:</strong> ${produto.id}</p>
            <p><strong>Nome:</strong> ${produto.nome}</p>
            <p><strong>Valor:</strong> R$ ${produto.valor}</p>
            <p><strong>Saldo:</strong> ${produto.saldo}</p>
            <p><strong>Saldo Mínimo:</strong> ${produto.saldomin}</p>
            <hr>
        `;
        produtosList.appendChild(divProduto);
    });
}

document.getElementById('carregarListaBtn').addEventListener('click', loadProduto);



async function deletarProduto(id) {
    fetch(`http://localhost:8080/produto/${id}`, {
        method: "DELETE",
    }).then(response => {
        if(!response.ok){
            throw new Error('Erro ao deletar produtos');
        }
        loadProduto()
    }).catch(error => {
        console.log("Erro:", error);
    });
}

document.addEventListener("DOMContentLoaded", () => {
    loadProduto();
    const produtoForm = document.getElementById('produtoForm')
    const carregarProdutosBtn = document.getElementById('carregarProdutosBtn')
    if(produtoForm instanceof HTMLFormElement && 
        carregarProdutosBtn instanceof HTMLButtonElement){
        produtoForm.addEventListener("submit", saveProduto);
        carregarProdutosBtn.addEventListener("click", loadProduto);
    }
})