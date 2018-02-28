package test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.koitt.book.dao.BookDao;
import com.koitt.book.dao.UsersDao;
import com.koitt.book.model.Authority;
import com.koitt.book.model.AuthorityId;
import com.koitt.book.model.Book;
import com.koitt.book.model.BookException;
import com.koitt.book.model.Users;
import com.koitt.book.model.UsersException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/test/config/applicationContext.xml")
public class JUnitTest {

	@Autowired
	private BookDao bookDao;

	@Autowired
	private UsersDao usersDao;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	private Users users1;
	private Users users2;
	private Users users3;

	private Authority admin;
	private Authority user;
	private Set<Authority> adminSet = new HashSet<>();
	private Set<Authority> userSet = new HashSet<>();
	private Set<Authority> bothSet = new HashSet<>();

	private Book book1;

	@Before
	public void setUp() {
		String password = passwordEncoder.encode("4611");

		this.users1 = new Users(null, "user1@koitt.com", password, "1호", null);
		this.users2 = new Users(null, "user2@koitt.com", password, "2호", null);
		this.users3 = new Users(null, "user3@koitt.com", password, "3호", null);

		this.admin = new Authority(AuthorityId.ADMIN.getAuthorityId(), AuthorityId.ADMIN.name());
		this.user = new Authority(AuthorityId.USER.getAuthorityId(), AuthorityId.USER.name());

		adminSet.add(admin);
		userSet.add(user);
		bothSet.add(admin);
		bothSet.add(user);

		this.users1.setAuthorities(adminSet);
		this.users2.setAuthorities(userSet);
		this.users3.setAuthorities(bothSet);

		// 도서
		this.book1 = new Book(null, null, "제목-1", "저자-1", "출판사-1", 10000, "내용", null);
	}


	@Test
	public void addAndGetUsers() throws UsersException, BookException {
		bookDao.deleteAll();
		assertThat(bookDao.getCount(), is(0));

		usersDao.deleteAllusersAuthority();
		assertThat(usersDao.getCountUsersAuthority(), is(0));

		usersDao.deleteAll();
		assertThat(usersDao.getCount(), is(0));

		usersDao.insert(users1);
		users1.setNo(usersDao.selectLastInsertId());
		usersDao.insert(users2);
		users2.setNo(usersDao.selectLastInsertId());
		usersDao.insert(users3);
		users3.setNo(usersDao.selectLastInsertId());
		assertThat(usersDao.getCount(), is(3));

		usersDao.insertAuthority(users1);
		usersDao.insertAuthority(users2);
		usersDao.insertAuthority(users3);
		assertThat(usersDao.getCountUsersAuthority(), is(4));

		Users usersget1 = usersDao.selectByEmail(users1.getEmail());
		assertThat(usersget1.getName(), is(users1.getName()));
		assertTrue(passwordEncoder.matches("4611", usersget1.getPassword()));

		Users usersget2 = usersDao.selectByEmail(users2.getEmail());
		assertThat(usersget2.getName(), is(users2.getName()));
		assertTrue(passwordEncoder.matches("4611", usersget2.getPassword()));

		Users usersget3 = usersDao.selectByEmail(users3.getEmail());
		assertThat(usersget3.getName(), is(users3.getName()));
		assertTrue(passwordEncoder.matches("4611", usersget2.getPassword()));
	}

	@Test
	public void addAndGetBook() throws BookException, UsersException {
		// 1. 독립적인 단위 테스트를 위해 테이블 삭제 -> book, user_authority, users 순으로 삭제
		bookDao.deleteAll();
		assertThat(bookDao.getCount(), is(0));

		usersDao.deleteAllusersAuthority();
		assertThat(usersDao.getCountUsersAuthority(), is(0));

		usersDao.deleteAll();
		assertThat(usersDao.getCount(), is(0));

		// 2. 도서를 등록할 사용자 1명 추가하기
		usersDao.insert(users1);	// 사용자 추가
		Integer userNo = usersDao.selectLastInsertId();	// 추가한 사용자의 번호 가져오기
		assertThat(usersDao.getCount(), is(1));

		// 3. 도서 등록
		book1.setUserNo(userNo);
		bookDao.insert(book1);
		Integer boardNo = bookDao.selectLastInsertId();
		assertThat(bookDao.getCount(), is(1));

		// 4. 도서 비교 테스트
		Book bookget1 = bookDao.select(boardNo.toString());
		assertThat(bookget1.getTitle(), is(book1.getTitle()));
		assertThat(bookget1.getAuthor(), is(book1.getAuthor()));
		assertThat(bookget1.getPublisher(), is(book1.getPublisher()));
		assertThat(bookget1.getPrice(), is(book1.getPrice()));
		assertThat(bookget1.getDescription(), is(book1.getDescription()));
	}
}
