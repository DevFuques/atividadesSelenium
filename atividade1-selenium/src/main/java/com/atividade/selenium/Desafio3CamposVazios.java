package com.atividade.selenium;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Desafio3CamposVazios {
	
    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();

        try {
            System.out.println("1. Abrindo o navegador Firefox...");
            driver.manage().window().maximize();

            String caminhoArquivo = "file:C:\\Users\\021.910032\\Downloads\\atividadesSelenium-main\\atividade1-selenium/site-teste-simples.html";
            driver.get(caminhoArquivo);
            System.out.println("2 - Página carregada: " + caminhoArquivo);

            WebElement inputUsuario = driver.findElement(By.id("username"));
            inputUsuario.sendKeys("");
            System.out.println("3 - Campo 'Usuário' preenchido com:  ");

            WebElement inputSenha = driver.findElement(By.id("password"));
            inputSenha.sendKeys("");
            System.out.println("4 - Campo 'Senha' preenchido com:  ");

            Select selectPerfil = new Select(driver.findElement(By.id("perfil")));
            selectPerfil.selectByValue("");
            System.out.println("5 - Perfil selecionado:  ");

            WebElement botaoEntrar = driver.findElement(By.id("btnLogin"));
            botaoEntrar.click();
            System.out.println("6 - Botão 'Entrar' clicado");

            Thread.sleep(1000); 

            WebElement mensagemSucesso = driver.findElement(By.id("msgSuccess"));

            if (mensagemSucesso.isDisplayed()) {
                System.out.println("7 - Login bem-sucedido! Mensagem: " + mensagemSucesso.getText());
            } else {
                System.out.println("7 - Login falhou! Mensagem de sucesso não visível.");
            }

            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File imagem = screenshot.getScreenshotAs(OutputType.FILE);
            File destino = new File("screenshot-campoVazio.png");
            Files.copy(imagem.toPath(), destino.toPath(), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("8 - Screenshot capturado: screenshot-campoVazio.png");

        } catch (Exception e) {
            System.out.println("Erro durante o teste: " + e.getMessage());
        } finally {
            driver.quit();
            System.out.println("9 - Navegador fechado. Teste finalizado.");
        }
    }

}
