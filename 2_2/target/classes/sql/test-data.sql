insert into CATEGORY (name) values ('Science Fiction');
insert into CATEGORY (name) values ('Literary Fiction');
insert into CATEGORY (name) values ('Essays');
insert into CATEGORY (name) values ('Poetry');

insert into BOOK (category_id, isbn, title, price) values (4, '978-1933517407', 'Bluets', 13.69);
insert into BOOK (category_id, isbn, title, price) values (1, '978-0060512750', 'The Dispossessed', 11.19);
insert into BOOK (category_id, isbn, title, price) values (3, '978-0060927516', 'Testaments Betrayed', 15.49);
insert into BOOK (category_id, isbn, title, price) values (2, '978-0679760801', 'The Master and Margarita', 13.87);
insert into BOOK (category_id, isbn, title, price) values (2, '978-0140096934', 'The Book of Laughter and Forgetting', 16.99);

insert into AUTHOR (first_name, last_name, description) values ('Maggie', 'Nelson', "Maggie Nelson (born 1973) is an American writer. She has been described as a genre-busting writer defying classification, working in autobiography, art criticism, theory, scholarship, and poetry. Nelson has been the recipient of a 2016 MacArthur Fellowship[1], a 2012 Creative Capital Literature Fellowship[2], a 2011 NEA Fellowship in Poetry[3], and a 2010 Guggenheim Fellowship in Nonfiction. Other honors include the 2015 National Book Critics Circle Award in Criticism and a 2007 Andy Warhol Foundation/Creative Capital Arts Writers Grant.");
insert into AUTHOR (first_name, last_name, description) values ('Ursula', 'LeGuin', 'Ursula Kroeber Le Guin (October 21, 1929 – January 22, 2018) was an American author best known for her works of speculative fiction, including science fiction works set in her Hainish universe, and the Earthsea fantasy series. She was first published in 1959, and her literary career spanned nearly sixty years, yielding more than twenty novels and over a hundred short stories, in addition to poetry, literary criticism, translations, and children\'s books. Frequently described as an author of science fiction, Le Guin has also been called a "major voice in American Letters."[2] Le Guin herself said she would prefer to be known as an "American novelist".[3]');
insert into AUTHOR (first_name, last_name, description) values ('Milan', 'Kundera', 'Milan Kundera (UK: /ˈkʊndərə, ˈkʌn-/,[3][4] Czech: [ˈmɪlan ˈkundɛra] (About this soundlisten); born 1 April 1929) is a Czech writer who went into exile in France in 1975, becoming a naturalised French citizen in 1981. Kundera\'s Czechoslovak citizenship was revoked in 1979. He was given a Czech citizenship in 2019. He "sees himself as a French writer and insists his work should be studied as French literature and classified as such in book stores".[5]
Kundera\'s best-known work is The Unbearable Lightness of Being. Prior to the Velvet Revolution of 1989 the communist régime in Czechoslovakia banned his books. He lives virtually incognito and rarely speaks to the media.[6] He was thought to be a contender for the Nobel Prize in Literature, and was also a nominee for other awards.[7][8]');
insert into AUTHOR (first_name, last_name, description) values ('Mikhail', 'Bulgakov', 'Mikhail Afanasyevich Bulgakov (Russian: Михаил Афанасьевич Булгаков;[2] 15 May [O.S. 3 May] 1891 – 10 March 1940) was a Russian writer, medical doctor and playwright active in the first half of the 20th century.[1] He is best known for his novel The Master and Margarita, published posthumously, which has been called one of the masterpieces of the 20th century.[3]');

insert into AUTHOR_BOOK (AUTHOR_ID, BOOK_ID) values (1,1);
insert into AUTHOR_BOOK (AUTHOR_ID, BOOK_ID) values (2,2);
insert into AUTHOR_BOOK (AUTHOR_ID, BOOK_ID) values (3,3);
insert into AUTHOR_BOOK (AUTHOR_ID, BOOK_ID) values (4,4);
insert into AUTHOR_BOOK (AUTHOR_ID, BOOK_ID) values (3,5);