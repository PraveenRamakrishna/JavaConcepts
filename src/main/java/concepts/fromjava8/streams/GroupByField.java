package concepts.fromjava8.streams;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

public class GroupByField {
	public static void main(String[] args) {
		List<Article> articles = new ArrayList<>();
		articles.add(new Article("1", new Author("1", "A1", new Date()), new Book("1", "B1", "G1"), new Date()));
		articles.add(new Article("2", new Author("1", "A1", new Date()), new Book("2", "B2", "G1"), new Date()));
		articles.add(new Article("3", new Author("2", "A2", new Date()), new Book("3", "B3", "G2"), new Date()));
		articles.add(new Article("4", new Author("3", "A3", new Date()), new Book("4", "B4", "G3"), new Date()));
		articles.add(new Article("5", new Author("3", "A3", new Date()), new Book("5", "B5", "G3"), new Date()));
		articles.add(new Article("6", new Author("1", "A1", new Date()), new Book("6", "B6", "G3"), new Date()));
		
		Map<Author, List<Book>> booksByAuthor = articles.stream().collect(Collectors.groupingBy(Article::getAuthor,Collectors.mapping(Article::getBook, Collectors.toList())));
		System.out.println(booksByAuthor);
		
	}

	@RequiredArgsConstructor
	@Data
	static class Author{
		final private String id;
		
		final private String name;
		
		final private Date addedOn;

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Author other = (Author) obj;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			return true;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			return result;
		}
	}
	
	@AllArgsConstructor
	@Data
	static class Book{
		private String id;
		
		private String name;
		
		private String genre;
	}
	

	@AllArgsConstructor
	@Data
	static class Article{
		private String id;
		
		private Author author;
		
		private Book book;
		
		private Date added;
	}

}
