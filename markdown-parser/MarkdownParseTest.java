import static org.junit.Assert.*;
import org.junit.*;

import java.util.ArrayList;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class MarkdownParseTest {
	@Test
		public void addition() {
		assertEquals(2, 1 + 1);
	}

	@Test 
	public void basicTest() throws IOException {
		MarkdownParse mdp = new MarkdownParse();
		Path fileName = Path.of("test-file.md");
		String content = Files.readString(fileName);
		ArrayList links = mdp.getLinks(content);
		assertEquals(List.of("https://something.com", "some-thing.html"), links);
	}
	@Test 
	public void imageTest() throws IOException {
		MarkdownParse mdp = new MarkdownParse();
		Path fileName = Path.of("new-test.md");
		String content = Files.readString(fileName);
		ArrayList links = mdp.getLinks(content);
		assertEquals(List.of("https://something.com", "some-thing.html", "yeah.html"), links);
	}
	@Test 
	public void bracketsParenthesesTest() throws IOException {
		MarkdownParse mdp = new MarkdownParse();
		Path fileName = Path.of("test3.md");
		String content = Files.readString(fileName);
		ArrayList links = mdp.getLinks(content);
		assertEquals(List.of("https://something.com", "some-thing.html"), links);
	}
	@Test 
	public void sequentialLinksTest() throws IOException {
		MarkdownParse mdp = new MarkdownParse();
		Path fileName = Path.of("test4.md");
		String content = Files.readString(fileName);
		ArrayList links = mdp.getLinks(content);
		assertEquals(List.of("url.com", "somethingelse.com", "https://something.com", "some-thing.html"), links);
	}
	@Test 
	public void repoTest1() throws IOException {
		MarkdownParse mdp = new MarkdownParse();
		Path fileName = Path.of("test-file2.md");
		String content = Files.readString(fileName);
		ArrayList links = mdp.getLinks(content);
		assertEquals(List.of("https://something.com", "some-page.html"), links);
	}
	@Test 
	public void repoTest2() throws IOException {
		MarkdownParse mdp = new MarkdownParse();
		Path fileName = Path.of("test-file3.md");
		String content = Files.readString(fileName);
		ArrayList links = mdp.getLinks(content);
		assertEquals(new ArrayList<String>(), links);
	}
	@Test 
	public void repoTest3() throws IOException {
		MarkdownParse mdp = new MarkdownParse();
		Path fileName = Path.of("test-file4.md");
		String content = Files.readString(fileName);
		ArrayList links = mdp.getLinks(content);
		assertEquals(new ArrayList<String>(), links);
	}
	@Test 
	public void repoTest4() throws IOException {
		MarkdownParse mdp = new MarkdownParse();
		Path fileName = Path.of("test-file5.md");
		String content = Files.readString(fileName);
		ArrayList links = mdp.getLinks(content);
		assertEquals(new ArrayList<String>(), links);
	}
	@Test 
	public void repoTest5() throws IOException {
		MarkdownParse mdp = new MarkdownParse();
		Path fileName = Path.of("test-file6.md");
		String content = Files.readString(fileName);
		ArrayList links = mdp.getLinks(content);
		assertEquals(new ArrayList<String>(), links);
	}
	@Test
	public void repoTest6() throws IOException {
		MarkdownParse mdp = new MarkdownParse();
		Path fileName = Path.of("test-file7.md");
		String content = Files.readString(fileName);
		ArrayList links = mdp.getLinks(content);
		assertEquals(new ArrayList<String>(), links);
	}
	@Test
	public void repoTest7() throws IOException {
		MarkdownParse mdp = new MarkdownParse();
		Path fileName = Path.of("test-file8.md");
		String content = Files.readString(fileName);
		ArrayList links = mdp.getLinks(content);
		assertEquals(List.of("a link on the first line"), links);
	}
}
