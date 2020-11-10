var contador = 3;
var contadorSelecao = 3;
var contadorHorizontal = 3;
var contadorCaixa = 3;
var contadorTexto = 0;
var contadorCaixaHorizontal = 3;
var removeEdicao = 0;


function   validar() {

    if ((document.form.Username.value === "")) {
        document.form.Username.focus();
        return false;
    }
    if ((document.form.Loginname.value === "")) {
        alert("Campo Obrigat\u00f3rio N\u00e3o Preenchido");
        document.form.Loginname.focus();
        return false;
    }

    if ((document.form.Email.value === "") || (document.form.Email.value.indexOf('@') === -1) || (document.form.Email.value.indexOf('.') === -1)) {
        alert("Email Invalido Verifique-o");
        document.form.Email.focus();
        return false;
    }

    if ((document.form.Password.value !== document.form.Password2.value)) {
        alert("As Senhas N\u00e3o Confere ou Esta em Branco.");
        document.form.Password.focus();
        return false;
    }
    if ((document.form.Password.value === "") || (document.form.Password2.value === "")) {
        alert("As Senhas N\u00e3o Confere ou Esta em Branco..");
        document.form.Password.focus();
        return false;
    }
}

function   validarCadastro() {


    if ((document.form.Password.value !== document.form.Password2.value)) {
        alert("As Senhas N\u00e3o Confere ou Esta em Branco.");
        document.form.Password.focus();
        return false;
    }
    if ((document.form.Password.value === "") || (document.form.Password2.value === "")) {
        alert("As Senhas N\u00e3o Confere ou Esta em Branco..");
        document.form.Password.focus();
        return false;
    }
}

function   validarLogin() {
    if ((document.form1.Username.value === "")) {
        alert("Campo Obrigat\u00f3rio N\u00e3o Preenchido");
        document.form1.Username.focus();
        return false;
    }

    if ((document.form1.Password.value === "")) {
        alert("Campo Obrigat\u00f3rio N\u00e3o Preenchido");
        document.form1.Password.focus();
        return false;
    }
}

function validarMultipla() {
    for (var i = 0; i <= contador; i++) {
        if ((document.formulario.textfiel.value === "") || (document.formulario.textfiel.value.indexOf('?') === -1)) {
            alert("Campo N\u00e3o Preenchido ou Falta [?]");
            document.formulario.textfiel.focus();
            return false;
        }
        if (document.getElementById("textfield" + i).value === "") {
            alert("Campo N\u00e3o Preenchido");
            document.getElementById("textfield" + i).focus();
            return false;
        }
        if (document.getElementById("text2").value === "") {
            alert("Campo N\u00e3o Preenchido");
            document.getElementById("text2").focus();
            return false;
        }
        if (document.getElementById("text3").value === "") {
            alert("Campo N\u00e3o Preenchido");
            document.getElementById("text3").focus();
            return false;
        }
    }
}

function validarCombinacao() {
    for (var i = 0; i <= contadorCaixa; i++) {
        if ((document.formulario.textfie.value === "") || (document.formulario.textfie.value.indexOf('?') === -1)) {
            alert("Campo N\u00e3o Preenchido ou Falta [?]");
            document.formulario.textfie.focus();
            return false;
        }
        if (document.getElementById("text" + i).value === "") {
            alert("Campo N\u00e3o Preenchido");
            document.getElementById("text" + i).focus();
            return false;
        }
        if (document.getElementById("text2").value === "") {
            alert("Campo N\u00e3o Preenchido");
            document.getElementById("text2").focus();
            return false;
        }
        if (document.getElementById("text3").value === "") {
            alert("Campo N\u00e3o Preenchido");
            document.getElementById("text3").focus();
            return false;
        }
    }
}

function validarCombinacaoHorizontal() {
    for (var i = 0; i <= contadorCaixaHorizontal; i++) {
        if ((document.formulario.textfie.value === "") || (document.formulario.textfie.value.indexOf('?') === -1)) {
            alert("Campo N\u00e3o Preenchido ou Falta [?]");
            document.formulario.textfie.focus();
            return false;
        }
        if (document.getElementById("text" + i).value === "") {
            alert("Campo N\u00e3o Preenchido");
            document.getElementById("text" + i).focus();
            return false;
        }
        if (document.getElementById("text2").value === "") {
            alert("Campo N\u00e3o Preenchido");
            document.getElementById("text2").focus();
            return false;
        }
        if (document.getElementById("text3").value === "") {
            alert("Campo N\u00e3o Preenchido");
            document.getElementById("text3").focus();
            return false;
        }
    }
}
function validarTexto() {
    for (var i = 0; i <= contadorTexto; i++) {
        if ((document.getElementById("textf" + i).value === "") || (document.getElementById("textf" + i).value.indexOf('?') === -1)) {
            alert("Campo N\u00e3o Preenchido ou Falta [?]");
            document.getElementById("textf" + i).focus();
            return false;
        }
        if (document.getElementById("text2").value === "") {
            alert("Campo N\u00e3o Preenchido");
            document.getElementById("text2").focus();
            return false;
        }
        if (document.getElementById("text3").value === "") {
            alert("Campo N\u00e3o Preenchido");
            document.getElementById("text3").focus();
            return false;
        }
    }
}

function validarSelecao() {
    for (var i = 0; i <= contadorSelecao; i++) {
        if ((document.formulario.textfie.value === "") || (document.formulario.textfie.value.indexOf('?') === -1)) {
            alert("Campo N\u00e3o Preenchido ou Falta [?]");
            document.formulario.textfie.focus();
            return false;
        }
        if (document.getElementById("text2").value === "") {
            alert("Campo N\u00e3o Preenchido");
            document.getElementById("text2").focus();
            return false;
        }
        if (document.getElementById("text3").value === "") {
            alert("Campo N\u00e3o Preenchido");
            document.getElementById("text3").focus();
            return false;
        }
    }
}

function validarHistorico() {
    return true;
}

function questionarioEscolhido(estilo) {
    window.open(estilo);
}

function adicionar(ida) {
    var formulario = document.getElementById("formulario");
    contador++;
    var numeroPergunta = contador;
    numeroPergunta++;
    if (ida === "buttonsm") {
        formulario.innerHTML = formulario.innerHTML + "<div id='aqui" + contador + "'>"
                + "<p>&nbsp; &nbsp;" + numeroPergunta
                + "&nbsp;<input type='checkbox' name='checkbox" + contador + "' id='checkbox" + contador + "'/>"
                + "&nbsp;<input type='text' size='100' name='textfield" + contador + "' id='textfield" + contador + "'/>"
                + "&nbsp;<input type='button' name='buttons" + contador + "' id='buttons" + contador + "' style='color: #FF0000' value='X' onclick='remover(id)'/> "
                + "</p>"
                + "</div>";
        document.getElementById("tende").value = contador;
    }
}

function adicionarHorizontal(ida) {
    var formulario = document.getElementById("formulario");
    contadorHorizontal++;
    if (ida === "buttonsm") {
        formulario.innerHTML = formulario.innerHTML + "&nbsp; &nbsp;"
                + "&nbsp;<input type='checkbox' name='checkbox" + contadorHorizontal + "' id='checkbox" + contadorHorizontal + "'/>"
                + "&nbsp;<input type='text'  name='textfield" + contadorHorizontal + "' id='textfield" + contadorHorizontal + "'/>"
                + "&nbsp;<input type='button' name='buttons" + contadorHorizontal + "' id='buttons" + contadorHorizontal + "' style='color: #FF0000' value='X' onclick='removerHorizontal(id)'/> &nbsp; &nbsp;&nbsp; &nbsp;";
        document.getElementById("tende").value = contadorHorizontal;
    }
}

function adicionarTexto(ida) {
    var formulario = document.getElementById("formulario");
    contadorTexto++;
    if (ida === "buttonsm") {
        formulario.innerHTML = formulario.innerHTML + "<div id='aqui" + contadorTexto + "'>"
                + "<p>&nbsp; &nbsp;"
                + "Pergunta"
                + "<input type='text' size='100' name='textf" + contadorTexto + "' id='textf" + contadorTexto + "' />"
                + "</p>"
                + "<p>&nbsp; &nbsp;"
                + "&nbsp;<textarea size='100' name='textarea" + contadorTexto + "' id='textarea" + contadorTexto + "' cols='45' rows='5' /></textarea>"
                + "&nbsp;<input type='button' name='buttons" + contadorTexto + "' id='buttons" + contadorTexto + "' style='color: #FF0000' value='X' onclick='removerTexto(id)'/> "
                + "</p>"
                + "</div>";
        document.getElementById("tende").value = contadorTexto;
    }
}

function adicionarCaixa(ida) {
    var formulario = document.getElementById("formulario");
    contadorCaixa++;
    var numeroPergunta = contadorCaixa;
    numeroPergunta++;
    if (ida === "buttonsm") {
        formulario.innerHTML = formulario.innerHTML + "<div id='aqui" + contadorCaixa + "'>"
                + "<p>&nbsp; &nbsp;" + numeroPergunta
                + "&nbsp;<input type='radio' name='RadioGrup' id='RadioGrup'/>"
                + "&nbsp;<input type='text' size='100' name='textfield" + contadorCaixa + "' id='textfield" + contadorCaixa + "'/>"
                + "&nbsp;<input type='button' name='buttonsc" + contadorCaixa + "' id='buttonsc" + contadorCaixa + "' style='color: #FF0000' value='X' onclick='removerCaixa(id)'/> "
                + "</p>"
                + "</div>";
        document.getElementById("tende").value = contadorCaixa;
    }
}

function adicionarCaixaHorizontal(ida) {
    var formulario = document.getElementById("formulario");
    contadorCaixaHorizontal++;
    if (ida === "buttonsm") {
        formulario.innerHTML = formulario.innerHTML + "&nbsp;"
                + "&nbsp;<input type='radio' name='RadioGrup' id='RadioGrup'/>"
                + "&nbsp;<input type='text'  name='text" + contadorCaixaHorizontal + "' id='text" + contadorCaixaHorizontal + "'/>"
                + "&nbsp;<input type='button' name='buttonsc" + contadorCaixaHorizontal + "' id='buttonsc" + contadorCaixaHorizontal + "' style='color: #FF0000' value='X' onclick='removerCaixaHorizontal(id)'/> ";
        document.getElementById("tende").value = contadorCaixaHorizontal;
    }
}

function adicionarSelecao(ida) {
    var formulario = document.getElementById("formulario");
    contadorSelecao++;
    var numeroPergunta = contadorSelecao;
    numeroPergunta++;
    if (ida === "buttonsm") {
        formulario.innerHTML = formulario.innerHTML + "<div id='aqui" + contadorSelecao + "'>"
                + "<p>&nbsp; &nbsp;" + numeroPergunta
                + "&nbsp; &nbsp;<input type='text' size='110' name='textfield" + contadorSelecao + "' id='textfield" + contadorSelecao + "'/>"
                + "&nbsp;&nbsp;<input type='button' name='buttonsc" + contadorSelecao + "' id='buttonsc" + contadorSelecao + "' style='color: #FF0000' value='X' onclick='removerSelecao(id)'/> "
                + "</p>"
                + "</div>";
        document.getElementById("tende").value = contadorSelecao;
    }
}

function edicao(ida) {
    var formulario = document.getElementById("formulario");
    var contad = document.getElementById("tende").value;
    var indPergunta = document.getElementById("indipergunta").value;
    var numeroPergunta = document.getElementById("contapergunta").value;
    var contador1 = contad;
    contador1++;
    var contador2 = contador1;
    contador2++;
    var contador3 = contador2;
    contador3++;
    if (ida === "buttonsm") {
        formulario.innerHTML = formulario.innerHTML + "<div id='aqui" + contad + "'>"
                + "<input type='hidden' name='tipo2' id='tipo2' value='2' />"
                + "<p>"
                + "  <input type='button' name='buttonsm' id='buttonsm' style='color: #1E90FF; float:right'value='+' onclick='edicao(id)' />"
                + "  <input type='button' name='" + contad + "' id='" + contad + "' style='color: #FF0000; float:right'value='X' onclick='removerEdicao(id)' />"
                + "</p>"
                + "<br />"
                + "<p>"
                + "&nbsp; &nbsp;" + numeroPergunta + " ) "
                + "  <input type='text' name='textfie" + indPergunta + "' id='textfie" + indPergunta + "' size='100'  />"
                + "</p>"
                + "<p>&nbsp; &nbsp; 1"
                + "&nbsp;<input type='checkbox' name='checkbox" + contad + "' id='checkbox" + contad + "'/>"
                + "&nbsp;<input type='text' size='100' name='textfield" + contad + "' id='textfield" + contad + "'/>"
                + "&nbsp;<input type='button' name='buttons" + contad + "' id='buttons" + contad + "' style='color: #FF0000' value='X' onclick='remover(id)'/> "
                + "</p>"
                + "<p>&nbsp; &nbsp; 2"
                + "&nbsp;<input type='checkbox' name='checkbox" + contador1 + "' id='checkbox" + contador1 + "'/>"
                + "&nbsp;<input type='text' size='100' name='textfield" + contador1 + "' id='textfield" + contador1 + "'/>"
                + "&nbsp;<input type='button' name='buttons" + contador1 + "' id='buttons" + contador1 + "' style='color: #FF0000' value='X' onclick='remover(id)'/> "
                + "</p>"
                + "<p>&nbsp; &nbsp; 3"
                + "&nbsp;<input type='checkbox' name='checkbox" + contador2 + "' id='checkbox" + contador2 + "'/>"
                + "&nbsp;<input type='text' size='100' name='textfield" + contador2 + "' id='textfield" + contador2 + "'/>"
                + "&nbsp;<input type='button' name='buttons" + contador2 + "' id='buttons" + contador2 + "' style='color: #FF0000' value='X' onclick='remover(id)'/> "
                + "</p>"
                + "<p>&nbsp; &nbsp; 4"
                + "&nbsp;<input type='checkbox' name='checkbox" + contador3 + "' id='checkbox" + contador3 + "'/>"
                + "&nbsp;<input type='text' size='100' name='textfield" + contador3 + "' id='textfield" + contador3 + "'/>"
                + "&nbsp;<input type='button' name='buttons" + contador3 + "' id='buttons" + contador3 + "' style='color: #FF0000' value='X' onclick='remover(id)'/> "
                + "</p>"
                + "</div>";
        contador3++;
        numeroPergunta++;
        indPergunta++;
        document.getElementById("tende").value = contador3;
        document.getElementById("contapergunta").value = numeroPergunta;
        document.getElementById("indipergunta").value = indPergunta;
    }
}

function edicaoHorizontal(ida) {
    var formulario = document.getElementById("formulario");
    var contad = document.getElementById("tende").value;
    var indPergunta = document.getElementById("indipergunta").value;
    var numeroPergunta = document.getElementById("contapergunta").value;
    var contador1 = contad;
    contador1++;
    var contador2 = contador1;
    contador2++;
    var contador3 = contador2;
    contador3++;
    if (ida === "buttonsm") {
        formulario.innerHTML = formulario.innerHTML + "<div id='aqui" + contad + "'>"
                + "<input type='hidden' name='tipo5' id='tipo5' value='5' />"
                + "<p>"
                + "  <input type='button' name='buttonsm' id='buttonsm' style='color: #1E90FF; float:right'value='+' onclick='edicaoHorizontal(id)' />"
                + "  <input type='button' name='" + contad + "' id='" + contad + "' style='color: #FF0000; float:right'value='X' onclick='removerEdicao(id)' />"
                + "</p>"
                + "<br/>"
                + "<p>"
                + "&nbsp; &nbsp;" + numeroPergunta + " ) "
                + "  <input type='text' name='textfie" + indPergunta + "' id='textfie" + indPergunta + "' size='100'  />"
                + "</p>"
                + "&nbsp; &nbsp; 1"
                + "&nbsp;<input type='checkbox' name='checkbox" + contad + "' id='checkbox" + contad + "'/>"
                + "&nbsp;<input type='text'  name='textfield" + contad + "' id='textfield" + contad + "'/>"
                + "&nbsp;<input type='button' name='buttons" + contad + "' id='buttons" + contad + "' style='color: #FF0000' value='X' onclick='removerHorizontal(id)'/> &nbsp; &nbsp;&nbsp; &nbsp;"
                + "&nbsp; &nbsp; 2"
                + "&nbsp;<input type='checkbox' name='checkbox" + contador1 + "' id='checkbox" + contador1 + "'/>"
                + "&nbsp;<input type='text'  name='textfield" + contador1 + "' id='textfield" + contador1 + "'/>"
                + "&nbsp;<input type='button' name='buttons" + contador1 + "' id='buttons" + contador1 + "' style='color: #FF0000' value='X' onclick='removerHorizontal(id)'/> &nbsp; &nbsp;&nbsp; &nbsp;"
                + "&nbsp; &nbsp; 3"
                + "&nbsp;<input type='checkbox' name='checkbox" + contador2 + "' id='checkbox" + contador2 + "'/>"
                + "&nbsp;<input type='text'  name='textfield" + contador2 + "' id='textfield" + contador2 + "'/>"
                + "&nbsp;<input type='button' name='buttons" + contador2 + "' id='buttons" + contador2 + "' style='color: #FF0000' value='X' onclick='removerHorizontal(id)'/> &nbsp; &nbsp;&nbsp; &nbsp;"
                + "&nbsp; &nbsp; 4"
                + "&nbsp;<input type='checkbox' name='checkbox" + contador3 + "' id='checkbox" + contador3 + "'/>"
                + "&nbsp;<input type='text'  name='textfield" + contador3 + "' id='textfield" + contador3 + "'/>"
                + "&nbsp;<input type='button' name='buttons" + contador3 + "' id='buttons" + contador3 + "' style='color: #FF0000' value='X' onclick='removerHorizontal(id)'/> &nbsp; &nbsp;&nbsp; &nbsp;"
                + "</div>";
        contador3++;
        numeroPergunta++;
        indPergunta++;
        document.getElementById("tende").value = contador3;
        document.getElementById("contapergunta").value = numeroPergunta;
        document.getElementById("indipergunta").value = indPergunta;
    }
}

function edicaoTexto(ida) {
    var formulario = document.getElementById("formulario");
    var contad = document.getElementById("tende").value;
    var indPergunta = document.getElementById("indipergunta").value;
    var numeroPergunta = document.getElementById("contapergunta").value;
    if (ida === "buttonsm") {
        formulario.innerHTML = formulario.innerHTML + "<div id='aqui" + contad + "'>"
                + "<input type='hidden' name='tipo1' id='tipo1' value='1' />"
                + "<p>"
                + "  <input type='button' name='buttonsm' id='buttonsm' style='color: #1E90FF; float:right'value='+' onclick='edicaoTexto(id)' />"
                + "  <input type='button' name='" + contad + "' id='" + contad + "' style='color: #FF0000; float:right'value='X' onclick='removerEdicao(id)' />"
                + "</p>"
                + "<br />"
                + "<p>"
                + "&nbsp; &nbsp;" + numeroPergunta + " ) "
                + "  <input type='text' name='textfie" + indPergunta + "' id='textfie" + indPergunta + "' size='100'  />"
                + "</p>"
                + "<p>&nbsp; &nbsp;"
                + "&nbsp;<textarea size='100' name='textarea" + contad + "' id='textarea" + contad + "' cols='45' rows='5' /></textarea>"
                + "&nbsp;<input type='button' name='buttons" + contad + "' id='buttons" + contad + "' style='color: #FF0000' value='X' onclick='removerTexto(id)'/> "
                + "</p>"
                + "</div>";
        contad++;
        numeroPergunta++;
        indPergunta++;
        document.getElementById("tende").value = contad;
        document.getElementById("contapergunta").value = numeroPergunta;
        document.getElementById("indipergunta").value = indPergunta;
    }
}

function edicaoCaixa(ida) {
    var formulario = document.getElementById("formulario");
    var contad = document.getElementById("tende").value;
    var indPergunta = document.getElementById("indipergunta").value;
    var numeroPergunta = document.getElementById("contapergunta").value;
    var contador1 = contad;
    contador1++;
    var contador2 = contador1;
    contador2++;
    var contador3 = contador2;
    contador3++;
    if (ida === "buttonsm") {
        formulario.innerHTML = formulario.innerHTML + "<div id='aqui" + contad + "'>"
                + "<input type='hidden' name='tipo3' id='tipo3' value='3' />"
                + "<p>"
                + "  <input type='button' name='buttonsm' id='buttonsm' style='color: #1E90FF; float:right'value='+' onclick='edicaoCaixa(id)' />"
                + "  <input type='button' name='" + contad + "' id='" + contad + "' style='color: #FF0000; float:right'value='X' onclick='removerEdicao(id)' />"
                + "</p>"
                + "<br />"
                + "<p>"
                + "&nbsp; &nbsp;" + numeroPergunta + " ) "
                + "  <input type='text' name='textfie" + indPergunta + "' id='textfie" + indPergunta + "' size='100'  />"
                + "</p>"
                + "<p>&nbsp; &nbsp; 1"
                + "&nbsp;<input type='radio' name='RadioGrup' id='RadioGrup'/>"
                + "&nbsp;<input type='text' size='100' name='text" + contad + "' id='text" + contad + "'/>"
                + "&nbsp;<input type='button' name='buttonsc" + contad + "' id='buttonsc" + contad + "' style='color: #FF0000' value='X' onclick='removerCaixa(id)'/> "
                + "</p>"
                + "<p>&nbsp; &nbsp; 2"
                + "&nbsp;<input type='radio' name='RadioGrup' id='RadioGrup'/>"
                + "&nbsp;<input type='text' size='100' name='text" + contador1 + "' id='text" + contador1 + "'/>"
                + "&nbsp;<input type='button' name='buttonsc" + contador1 + "' id='buttonsc" + contador1 + "' style='color: #FF0000' value='X' onclick='removerCaixa(id)'/> "
                + "</p>"
                + "<p>&nbsp; &nbsp; 3"
                + "&nbsp;<input type='radio' name='RadioGrup' id='RadioGrup'/>"
                + "&nbsp;<input type='text' size='100' name='text" + contador2 + "' id='text" + contador2 + "'/>"
                + "&nbsp;<input type='button' name='buttonsc" + contador2 + "' id='buttonsc" + contador2 + "' style='color: #FF0000' value='X' onclick='removerCaixa(id)'/> "
                + "</p>"
                + "<p>&nbsp; &nbsp; 4"
                + "&nbsp;<input type='radio' name='RadioGrup' id='RadioGrup'/>"
                + "&nbsp;<input type='text' size='100' name='text" + contador3 + "' id='text" + contador3 + "'/>"
                + "&nbsp;<input type='button' name='buttonsc" + contador3 + "' id='buttonsc" + contador3 + "' style='color: #FF0000' value='X' onclick='removerCaixa(id)'/> "
                + "</p>"
                + "</div>";
        contador3++;
        numeroPergunta++;
        indPergunta++;
        document.getElementById("tende").value = contador3;
        document.getElementById("contapergunta").value = numeroPergunta;
        document.getElementById("indipergunta").value = indPergunta;
    }
}

function edicaoCaixaHorizontal(ida) {
    var formulario = document.getElementById("formulario");
    var contad = document.getElementById("tende").value;
    var indPergunta = document.getElementById("indipergunta").value;
    var numeroPergunta = document.getElementById("contapergunta").value;
    var contador1 = contad;
    contador1++;
    var contador2 = contador1;
    contador2++;
    var contador3 = contador2;
    contador3++;
    if (ida === "buttonsm") {
        formulario.innerHTML = formulario.innerHTML + "<div id='aqui" + contad + "'>"
                + "<input type='hidden' name='tipo6' id='tipo6' value='6' />"
                + "<p>"
                + "  <input type='button' name='buttonsm' id='buttonsm' style='color: #1E90FF; float:right'value='+' onclick='edicaoCaixaHorizontal(id)' />"
                + "  <input type='button' name='" + contad + "' id='" + contad + "' style='color: #FF0000; float:right'value='X' onclick='removerEdicao(id)' />"
                + "</p>"
                + "<br />"
                + "<p>"
                + "&nbsp; &nbsp;" + numeroPergunta + " ) "
                + "  <input type='text' name='textfie" + indPergunta + "' id='textfie" + indPergunta + "' size='100'  />"
                + "</p>"
                + "&nbsp; &nbsp; 1"
                + "&nbsp;<input type='radio' name='RadioGrup' id='RadioGrup'/>"
                + "&nbsp;<input type='text'  name='text" + contad + "' id='text" + contad + "'/>"
                + "&nbsp;<input type='button' name='buttonsc" + contad + "' id='buttonsc" + contad + "' style='color: #FF0000' value='X' onclick='removerCaixaHorizontal(id)'/> "
                + "&nbsp; &nbsp; 2"
                + "&nbsp;<input type='radio' name='RadioGrup' id='RadioGrup'/>"
                + "&nbsp;<input type='text'  name='text" + contador1 + "' id='text" + contador1 + "'/>"
                + "&nbsp;<input type='button' name='buttonsc" + contador1 + "' id='buttonsc" + contador1 + "' style='color: #FF0000' value='X' onclick='removerCaixaHorizontal(id)'/> "
                + "&nbsp; &nbsp; 3"
                + "&nbsp;<input type='radio' name='RadioGrup' id='RadioGrup'/>"
                + "&nbsp;<input type='text'  name='text" + contador2 + "' id='text" + contador2 + "'/>"
                + "&nbsp;<input type='button' name='buttonsc" + contador2 + "' id='buttonsc" + contador2 + "' style='color: #FF0000' value='X' onclick='removerCaixaHorizontal(id)'/> "
                + "&nbsp; &nbsp; 4"
                + "&nbsp;<input type='radio' name='RadioGrup' id='RadioGrup'/>"
                + "&nbsp;<input type='text'  name='text" + contador3 + "' id='text" + contador3 + "'/>"
                + "&nbsp;<input type='button' name='buttonsc" + contador3 + "' id='buttonsc" + contador3 + "' style='color: #FF0000' value='X' onclick='removerCaixaHorizontal(id)'/> "
                + "</div>";
        contador3++;
        numeroPergunta++;
        indPergunta++;
        document.getElementById("tende").value = contador3;
        document.getElementById("contapergunta").value = numeroPergunta;
        document.getElementById("indipergunta").value = indPergunta;
    }       
}

function edicaoSelecao(ida) {
    var formulario = document.getElementById("formulario");
    var contad = document.getElementById("tende").value;
    var indPergunta = document.getElementById("indipergunta").value;
    var numeroPergunta = document.getElementById("contapergunta").value;
    var contador1 = contad;
    contador1++;
    var contador2 = contador1;
    contador2++;
    var contador3 = contador2;
    contador3++;
    if (ida === "buttonsm") {
        formulario.innerHTML = formulario.innerHTML + "<div id='aqui" + contad + "'>"
                + "<input type='hidden' name='tipo4' id='tipo4' value='4' />"
                + "<p>"
                + "  <input type='button' name='buttonsm' id='buttonsm' style='color: #1E90FF; float:right'value='+' onclick='edicaoSelecao(id)' />"
                + "  <input type='button' name='" + contad + "' id='" + contad + "' style='color: #FF0000; float:right'value='X' onclick='removerEdicao(id)' />"
                + "</p>"
                + "<br />"
                + "<p>"
                + "&nbsp; &nbsp;" + numeroPergunta + " ) "
                + "  <input type='text' name='textfie" + indPergunta + "' id='textfie" + indPergunta + "' size='100'  />"
                + "</p>"
                + "<p>&nbsp; &nbsp; 1"
                + "&nbsp; &nbsp;<input type='text' size='110' name='text" + contad + "' id='text" + contad + "'/>"
                + "&nbsp;&nbsp;<input type='button' name='buttonsc" + contad + "' id='buttonsc" + contad + "' style='color: #FF0000' value='X' onclick='removerSelecao(id)'/> "
                + "</p>"
                + "<p>&nbsp; &nbsp; 2"
                + "&nbsp; &nbsp;<input type='text' size='110' name='text" + contador1 + "' id='text" + contador1 + "'/>"
                + "&nbsp;&nbsp;<input type='button' name='buttonsc" + contador1 + "' id='buttonsc" + contador1 + "' style='color: #FF0000' value='X' onclick='removerSelecao(id)'/> "
                + "</p>"
                + "<p>&nbsp; &nbsp; 3"
                + "&nbsp; &nbsp;<input type='text' size='110' name='text" + contador2 + "' id='text" + contador2 + "'/>"
                + "&nbsp;&nbsp;<input type='button' name='buttonsc" + contador2 + "' id='buttonsc" + contador2 + "' style='color: #FF0000' value='X' onclick='removerSelecao(id)'/> "
                + "</p>"
                + "<p>&nbsp; &nbsp; 4"
                + "&nbsp; &nbsp;<input type='text' size='110' name='text" + contador3 + "' id='text" + contador3 + "'/>"
                + "&nbsp;&nbsp;<input type='button' name='buttonsc" + contador3 + "' id='buttonsc" + contador3 + "' style='color: #FF0000' value='X' onclick='removerSelecao(id)'/> "
                + "</p>"
                + "</div>";
        contador3++;
        numeroPergunta++;
        indPergunta++;
        document.getElementById("tende").value = contador3;
        document.getElementById("contapergunta").value = numeroPergunta;
        document.getElementById("indipergunta").value = indPergunta;
    }
}

function remover(id) {
    for (var i = 0; i <= contador; i++) {
        if (id === "buttons" + i) {
            document.getElementById("aqui" + i).innerHTML = "";
        }
    }
}

function removerEdicao(id) {
    document.getElementById("textfield" + id).innerHTML = "";
    document.getElementById("aqui" + id).innerHTML = "";
}

function removerHorizontal(id) {
    var formulario = document.getElementById("formulario");
    for (var i = 0; i <= contadorHorizontal; i++) {
        if (id === "buttons" + i) {
            formulario.removeChild(document.getElementById("checkbox" + i));
            formulario.removeChild(document.getElementById("textfield" + i));
            formulario.removeChild(document.getElementById("buttons" + i));
        }
    }
}
function removerCaixa(id) {
    for (var i = 0; i <= contadorCaixa; i++) {
        if (id === "buttonsc" + i) {
            document.getElementById("aqui" + i).innerHTML = "";
        }
    }
}

function removerCaixaHorizontal(id) {
    var formulario = document.getElementById("formulario");
    for (var i = 0; i <= contadorCaixaHorizontal; i++) {
        if (id === "buttonsc" + i) {
            formulario.removeChild(document.getElementById("RadioGrup"));
            formulario.removeChild(document.getElementById("text" + i));
            formulario.removeChild(document.getElementById("buttonsc" + i));
        }
    }
}

function removerSelecao(id) {
    for (var i = 0; i <= contadorSelecao; i++) {
        if (id === "buttonsc" + i) {
            document.getElementById("aqui" + i).innerHTML = "";
        }
    }
}

function removerTexto(id) {
    for (var i = 0; i <= contadorTexto; i++) {
        if (id === "buttons") {
            document.getElementById("aqui").innerHTML = "";
        }
        if (id === "buttons" + i) {
            document.getElementById("aqui" + i).innerHTML = "";
        }
    }

}

function marcadores(confere) {
    document.getElementById(confere).checked = true;
}

function visualizarRelatorio() {
    enviar("visualizar");
}

function gerarRelatorioPDF() {
    enviar("pdf");
}

function enviar(acao) {
    alert("Chegou 3");
    document.forms[0].acao.value = acao;
    window.location.assign("Relatorio");
}


