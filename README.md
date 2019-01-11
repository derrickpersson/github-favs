# Git Hub Favs

REST endpoint created to demonstrate knowledge of Java & Spring.

### Getting Started

```sh
git clone git@github.com:derrickpersson/github-favs.git
mvn clean install
```

Insert `-Dspring.profiles.active=local` when running locally

### Endpoints

`/repos` -> basic Git Hub Repo information for all Git Hub Repos

`/repos/{id}` -> basic Git Hub Repo information for a single Repo

`/repos/{id}/commits` -> basic Git Hub Commit information for the specified Repo

See full list at `/swagger-ui.html`
