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

/// snippet 1 ///

	@Test

	public void testSnip_1_1() {
		List<String> actVal = MarkdownParse.getLinks("`[a link`](url.com)");
		List<String> expVal = new ArrayList<>();
		assertEquals(expVal,actVal);
	}

	@Test 

	public void testSnip_1_2() {
		List<String> actVal = MarkdownParse.getLinks("[another link](`google.com)`");
		List<String> expVal = List.of("`google.com");
		assertEquals(expVal,actVal);
	}

	@Test 

	public void testSnip_1_3() {
		List<String> actVal = MarkdownParse.getLinks("[`cod[e`](google.com)");
		List<String> expVal = List.of("google.com");
		assertEquals(expVal,actVal);
	}

	@Test 

	public void testSnip_1_4() {
		List<String> actVal = MarkdownParse.getLinks("[`code]`](ucsd.edu)");
		List<String> expVal = List.of("ucsd.edu");
		assertEquals(expVal,actVal);
	}

	/// snippet 2 ///

	@Test

	public void testSnip2_1() throws IOException {
		List<String> actVal = MarkdownParse.getLinks(
			"[a [nested link](a.com)](b.com)");
		List<String> expVal = List.of("a.com");
		assertEquals(expVal,actVal);
	}

	@Test

	public void testSnip2_2() {
		List<String> actVal = MarkdownParse.getLinks(
			"[a nested parenthesized url](a.com(()))");
		List<String> expVal = List.of("a.com(())");
		assertEquals(expVal,actVal);
	}

	@Test

	public void testSnip2_3() throws IOException {
		List<String> actVal = MarkdownParse.getLinks(Files.readString(
			Path.of("snip2_3.md")));
		List<String> expVal = List.of("example.com");
		assertEquals(expVal,actVal); 
	}


	/// snippet 3 ///

	@Test 

	public void testSnip3_1() throws IOException {
		Path file = Path.of("snip3_1.md");
		String fileContent = Files.readString(file);
		List<String> expVal = new ArrayList<>();
		assertEquals(expVal,MarkdownParse.getLinks(fileContent));
	}

	@Test

	public void testSnip3_2() throws IOException {
		Path file = Path.of("snip3_2.md");
		String fileContent = Files.readString(file);
		List<String> expVal = List.of(
			"https://sites.google.com/eng.ucsd.edu/cse-15l-spring-2022/schedule");
		assertEquals(expVal, MarkdownParse.getLinks(fileContent));
	}

	@Test

	public void testSnip3_3() throws IOException{
		Path file = Path.of("snip3_3.md");
		String fileContent = Files.readString(file);
		List<String> expVal = new ArrayList<>();
		assertEquals(expVal,MarkdownParse.getLinks(fileContent));
	}

	@Test

	public void testSnip3_4() throws IOException {
		Path file = Path.of("snip3_4.md");
		String fileContent = Files.readString(file);
		List<String> expVal = new ArrayList<>();
		assertEquals(expVal,MarkdownParse.getLinks(fileContent));
	}
}
