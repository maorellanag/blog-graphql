# Blog GraphQL project

This is a simple project to test GraphQL features integrated into a SpringBoot app.

# Inspiration

It's inspired into the Reddit platform. The challenge is to design an API that allow to retrieve only the required information for the different clients.

In the general page clients need to list posts. Different clients needs different fields.

**web browser** needs to show the following attributes
  - author, time created, title, content, votes, number of comments.

**mobile app** needs to show the following attributes
  - author, time created, title, votes, number of comments.

# Example of GraphQL queries

## Create post

```graphql
mutation {
  createPost(author: "Dexter", title: "My First Post", content: "Hello, world!") {
    id
    title
  }
}
```

## Create comment

```graphql
mutation {
    createComment(
      postId:"1",
      author: "Lucas",
      content: "Hello there!"
    ) {
        id
    }
}
```


## Retrieve data for web client 

```graphql
query {
    posts {
        author,
        title,
        createdTime,
        content,
        votesCount,
        commentsCount
    }
}
```


## Retrieve data for mobile client

```graphql
query {
    posts {
        author,
        title,
        createdTime,
        votesCount,
        commentsCount
    }
}
```
