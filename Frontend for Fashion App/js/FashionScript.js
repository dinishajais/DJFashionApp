const BASE_URL = "http://localhost:8080/";

async function populateTrendingItems(categoryId, subCategoryId, elementId) {
    const container = document.getElementById(elementId);
    container.innerHTML = ""; // Clear existing content

    try {
        // Make an API call to fetch trending items
        const response = await fetch(`http://localhost:8080/api/items/trending?categoryId=${categoryId}&subcategoryId=${subCategoryId}`);
        if (!response.ok) {
            throw new Error(`Failed to fetch data: ${response.statusText}`);
        }
        const data = await response.json();

        // Populate the container with fetched items
        data.forEach(item => {
            const itemDiv = document.createElement("div");
            itemDiv.className = "trending-item";

            const img = document.createElement("img");
            img.src = BASE_URL + item.imageUrl; // Prepend base URL to image URL
            img.alt = "Trending item";

            const name = document.createElement("p");
            name.textContent = `${item.name}`; // Display item ID or other info if needed

            itemDiv.appendChild(img);
            itemDiv.appendChild(name);
            container.appendChild(itemDiv);
        });
    } catch (error) {
        console.error("Error loading trending items:", error);
        container.innerHTML = "<p>Error loading items. Please try again later.</p>";
    }
}

// Populate trending items for each category
populateTrendingItems(1, 2, "trending-women"); // Example: categoryId=1, subCategoryId=1
populateTrendingItems(1, 1, "trending-men");   // Example: categoryId=2, subCategoryId=2
populateTrendingItems(1, 3, "trending-kids");  // Example: categoryId=3, subCategoryId=3
