// src/main/resources/static/js/vendas_script.js
document.addEventListener('DOMContentLoaded', () => {
    const produtoSelect = document.getElementById('produto');
    const quantidadeInput = document.getElementById('quantidade');
    const totalInput = document.getElementById('total');

    const produtos = {
        // Exemplo de produtos com preço
        'produto1': 100.00,
        'produto2': 200.00
        // Adicione mais produtos conforme necessário
    };

    produtoSelect.addEventListener('change', updateTotal);
    quantidadeInput.addEventListener('input', updateTotal);

    function updateTotal() {
        const produtoId = produtoSelect.value;
        const quantidade = parseInt(quantidadeInput.value, 10);
        const preco = produtos[produtoId];

        if (preco && quantidade > 0) {
            const total = preco * quantidade;
            totalInput.value = `R$ ${total.toFixed(2)}`;
        } else {
            totalInput.value = '';
        }
    }
});
