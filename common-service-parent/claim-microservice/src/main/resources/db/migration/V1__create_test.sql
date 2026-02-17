CREATE table claim.test(
                           id SERIAL PRIMARY KEY,
                           created TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                           updated TIMESTAMP
)